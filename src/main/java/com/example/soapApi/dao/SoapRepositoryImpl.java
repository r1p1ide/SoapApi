package com.example.soapApi.dao;

import com.example.soapApi.dto.IncomeRequest;
import com.example.soapApi.dto.OutcomeDto;
import com.example.soapApi.dto.OutcomeRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.logging.Logger;

import static com.example.soapApi.resources.LoggerResources.EXIT;
import static java.sql.Types.VARCHAR;
import static java.util.logging.Level.INFO;
import static com.example.soapApi.resources.LoggerResources.ENTRY;

@Repository
@RequiredArgsConstructor
@Transactional(transactionManager = "transactionManager")
public class SoapRepositoryImpl implements SoapRepository{

    private final static Logger LOG = Logger.getLogger(SoapRepositoryImpl.class.getCanonicalName());

    private final NamedParameterJdbcTemplate jdbcNamedTemplate;

    private static final String SQL_INCOME =
            "INSERT INTO socks VALUES (null, :color, :cottonPart, :amount)";

    private static final String SQL_OUTCOME =
            "UPDATE socks SET amount = :amount WHERE color = :color AND cottonPart = :cottonPart";

    private static final String SQL_FIND_SOCK_BY_COLOR_AND_COTTON_PART =
            "SELECT * FROM socks WHERE color = :color AND cottonPart = :cottonPart";

    @Override
    public void income(IncomeRequest income) {
        LOG.log(INFO, ENTRY);
        jdbcNamedTemplate.update(SQL_INCOME,
                new MapSqlParameterSource()
                        .addValue("color", income.getColor(), VARCHAR)
                        .addValue("cottonPart", income.getCottonPart(), VARCHAR)
                        .addValue("amount", income.getAmount(), VARCHAR));
        LOG.log(INFO, EXIT);
    }

    @Override
    public void outcome(OutcomeRequest outcome) {
        LOG.log(INFO, ENTRY);
        List<OutcomeDto> list = jdbcNamedTemplate.query(SQL_FIND_SOCK_BY_COLOR_AND_COTTON_PART,
                new MapSqlParameterSource().addValue("color", outcome.getColor(), VARCHAR)
                        .addValue("cottonPart", outcome.getCottonPart(), VARCHAR),
                new BeanPropertyRowMapper<>(OutcomeDto.class));
        OutcomeDto result = null;
        if (list.size() > 0) {
            result = list.get(0);
        }
        if (result != null) {
            if (result.getAmount() > outcome.getAmount()) {
                jdbcNamedTemplate.update(SQL_OUTCOME,
                        new MapSqlParameterSource()
                                .addValue("color", outcome.getColor(), VARCHAR)
                                .addValue("cottonPart", outcome.getCottonPart(), VARCHAR)
                                .addValue("amount", result.getAmount() - outcome.getAmount(), VARCHAR));
            }
        }

    }
}
