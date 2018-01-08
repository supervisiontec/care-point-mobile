/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mac.care_point.manager_dashboard;

import com.mac.care_point.manager_dashboard.model.MBranch;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author kavish manjitha
 */
public interface ViewRepository extends JpaRepository<MBranch, Integer> {

    @Query(value = "select \n"
            + "	(\n"
            + "	select count(t_job_card.index_no) from t_job_card WHERE t_job_card.`status`='pending'\n"
            + "	  and\n"
            + "	   ( :branch = null or t_job_card.branch  =  :branch )\n"
            + "	  and \n"
            + "      ( :fromDate is null or t_job_card.date >= :fromDate)\n"
            + "     and\n"
            + "      ( :toDate is null or t_job_card.date <= :toDate ))as pending_count ,\n"
            + "	(select COUNT(t_job_card.index_no) FROM t_job_card WHERE t_job_card.`status`='finished'\n"
            + "	  and\n"
            + "	   (t_job_card.branch = null or t_job_card.branch  =  :branch )\n"
            + "	  and \n"
            + "      ( :fromDate is null or t_job_card.date >= :fromDate)\n"
            + "     and\n"
            + "      ( :toDate is null or t_job_card.date <= :toDate ))as approved_count,\n"
            + "	count(t_job_card.index_no) as total_count\n"
            + "from \n"
            + "	t_job_card \n"
            + "where \n"
            + "  ( :branch = null or t_job_card.branch  =  :branch )\n"
            + "and \n"
            + "  ( :fromDate is null or t_job_card.date >= :fromDate)\n"
            + "and\n"
            + "  ( :toDate is null or t_job_card.date <= :toDate )", nativeQuery = true)
    public Object[] getJobCardDetails(@Param("branch") Integer branch, @Param("fromDate") String fromDate, @Param("toDate") String toDate);

    @Query(value = "select\n"
            + "	sum(t_customer_ledger.credit_amount) as total_amount,\n"
            + "	sum(t_customer_ledger.debit_amount) as total_pay_amount,\n"
            + "	sum(t_customer_ledger.credit_amount) - sum(t_customer_ledger.debit_amount) as credit_amount\n"
            + "from\n"
            + "	t_customer_ledger\n"
            + "	left JOIN t_invoice on t_invoice.index_no = t_customer_ledger.invoice\n"
            + "where \n"
            + "   ( :branch = null or t_invoice.branch  =  :branch )\n"
            + "and\n"
            + "   ( :fromDate is null or t_customer_ledger.date >= :fromDate )\n"
            + "and\n"
            + "   ( :toDate is null or t_customer_ledger.date <= :toDate )", nativeQuery = true
    )
    public Object[] getSalesDetails(@Param("branch") Integer branch, @Param("fromDate") String fromDate, @Param("toDate") String toDate);

    @Query(value = "select\n"
            + "t_customer_ledger.date,\n"
            + "sum(t_customer_ledger.credit_amount) as total_amount,\n"
            + "sum(t_customer_ledger.debit_amount) as total_pay_amount,\n"
            + "sum(t_customer_ledger.credit_amount) - sum(t_customer_ledger.debit_amount) as credit_amount\n"
            + "from\n"
            + "t_customer_ledger\n"
            + "left JOIN t_invoice on t_invoice.index_no = t_customer_ledger.invoice\n"
            + "where\n"
            + "( :branch = null or t_invoice.branch  = :branch )\n"
            + "and\n"
            + "( :fromDate is null or t_customer_ledger.date >= :fromDate )\n"
            + "and\n"
            + "( :toDate is null or t_customer_ledger.date <= :toDate )\n"
            + "group by t_customer_ledger.date", nativeQuery = true
    )
    public List<Object[]> getSalesDetailsList(@Param("branch") Integer branch, @Param("fromDate") String fromDate, @Param("toDate") String toDate);

    @Query(value = "select\n"
            + "t_job_card.date,\n"
            + "(\n"
            + "select count(j.index_no) from t_job_card j WHERE j.`status`='pending'\n"
            + "and\n"
            + "( :branch = null or j.branch  =  :branch )\n"
            + "and\n"
            + "(t_job_card.date=j.date)) as pending_count ,\n"
            + "(\n"
            + "select count(j.index_no) from t_job_card j WHERE j.`status`='finished'\n"
            + "and\n"
            + "( :branch = null or j.branch  =  :branch )\n"
            + "and\n"
            + "(t_job_card.date=j.date)) as finished_count ,\n"
            + "count(t_job_card.index_no )as total_count\n"
            + "from\n"
            + "t_job_card \n"
            + "where\n"
            + "( :branch = null or t_job_card.branch  = :branch )\n"
            + "and\n"
            + "( :fromDate is null or t_job_card.date >= :fromDate )\n"
            + "and\n"
            + "( :toDate is null or t_job_card.date <= :toDate )\n"
            + "group by t_job_card.date", nativeQuery = true)
    public List<Object[]> getJobCardDetailsList(@Param("branch") Integer branch, @Param("fromDate") String fromDate, @Param("toDate") String toDate);
}
