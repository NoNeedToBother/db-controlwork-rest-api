package ru.kpfu.itis.paramonov.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.kpfu.itis.paramonov.model.Transaction;

import java.math.BigDecimal;
import java.util.List;

public interface AggregationRepository extends JpaRepository<Transaction, Long> {
    @Query(value = "select c.code, extract(year from bt.conduction_date) as transaction_year," +
            "       extract(month from bt.conduction_date) as transaction_month," +
            "       count(bt.*) as transaction_count " +
            "from bank_transaction bt " +
            "join payment p on bt.payment = p.id " +
            "join country c on p.country = c.id " +
            "group by c.code, transaction_year, transaction_month", nativeQuery = true)
    List<Object[]> aggregateByCountries();

    @Query(value = "select c.code, extract(year from bt.conduction_date) as transaction_year, " +
            "       extract(month from bt.conduction_date) as transaction_month, " +
            "       count(bt.*) as transaction_count " +
            "from bank_transaction bt " +
            "join currency c on bt.currency = c.id " +
            "group by c.code, transaction_year, transaction_month", nativeQuery = true)
    List<Object[]> aggregateByCurrencies();

    @Query(value = "select p.status, extract(year from bt.conduction_date) as transaction_year, " +
            "       extract(month from bt.conduction_date) as transaction_month, " +
            "       count(bt.*) as transaction_count " +
            "from bank_transaction bt " +
            "join payment p on bt.payment = p.id " +
            "group by p.status, transaction_year, transaction_month", nativeQuery = true)
    List<Object[]> aggregateByStatuses();

    @Query(value = "select c.code, extract(year from bt.conduction_date) as transaction_year," +
            "       extract(month from bt.conduction_date) as transaction_month," +
            "       count(bt.*) as transaction_count " +
            "from bank_transaction bt " +
            "join payment p on bt.payment = p.id " +
            "join country c on p.country = c.id " +
            "where extract(year from bt.conduction_date) = :year and extract(month from bt.conduction_date) = :month " +
            "group by c.code, transaction_year, transaction_month", nativeQuery = true)
    List<Object[]> aggregateByCountriesAndYearAndMonth(@Param("year") BigDecimal year, @Param("month") BigDecimal month);

    @Query(value = "select c.code, extract(year from bt.conduction_date) as transaction_year," +
            "       extract(month from bt.conduction_date) as transaction_month," +
            "       count(bt.*) as transaction_count " +
            "from bank_transaction bt " +
            "join payment p on bt.payment = p.id " +
            "join country c on p.country = c.id " +
            "where extract(year from bt.conduction_date) = :year " +
            "group by c.code, transaction_year, transaction_month", nativeQuery = true)
    List<Object[]> aggregateByCountriesAndYear(@Param("year") BigDecimal year);

    @Query(value = "select c.code, extract(year from bt.conduction_date) as transaction_year, " +
            "       extract(month from bt.conduction_date) as transaction_month, " +
            "       count(bt.*) as transaction_count " +
            "from bank_transaction bt " +
            "join currency c on bt.currency = c.id " +
            "where extract(year from bt.conduction_date) = :year and extract(month from bt.conduction_date) = :month " +
            "group by c.code, transaction_year, transaction_month", nativeQuery = true)
    List<Object[]> aggregateByCurrenciesAndYearAndMonth(@Param("year") BigDecimal year, @Param("month") BigDecimal month);

    @Query(value = "select c.code, extract(year from bt.conduction_date) as transaction_year, " +
            "       extract(month from bt.conduction_date) as transaction_month, " +
            "       count(bt.*) as transaction_count " +
            "from bank_transaction bt " +
            "join currency c on bt.currency = c.id " +
            "where extract(year from bt.conduction_date) = :year " +
            "group by c.code, transaction_year, transaction_month", nativeQuery = true)
    List<Object[]> aggregateByCurrenciesAndYear(@Param("year") BigDecimal year);

    @Query(value = "select p.status, extract(year from bt.conduction_date) as transaction_year, " +
            "       extract(month from bt.conduction_date) as transaction_month, " +
            "       count(bt.*) as transaction_count " +
            "from bank_transaction bt " +
            "join payment p on bt.payment = p.id " +
            "where extract(year from bt.conduction_date) = :year and extract(month from bt.conduction_date) = :month " +
            "group by p.status, transaction_year, transaction_month", nativeQuery = true)
    List<Object[]> aggregateByStatusesAndYearAndMonth(@Param("year") BigDecimal year, @Param("month") BigDecimal month);

    @Query(value = "select p.status, extract(year from bt.conduction_date) as transaction_year, " +
            "       extract(month from bt.conduction_date) as transaction_month, " +
            "       count(bt.*) as transaction_count " +
            "from bank_transaction bt " +
            "join payment p on bt.payment = p.id " +
            "where extract(year from bt.conduction_date) = :year " +
            "group by p.status, transaction_year, transaction_month", nativeQuery = true)
    List<Object[]> aggregateByStatusesAndYear(@Param("year") BigDecimal year);
}
