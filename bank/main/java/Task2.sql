select P.name,count (R.request_id) as total_per,
       sum(RR.result) as confirt,
       count (RR.result) - sum(RR.result) as fail,
       sum(RR.amount) as totalmoney_amount from tbl_partner[P]
left join tbl_request[R] on R.partner_id = P.partner_id
left join tbl_response[RR]  on RR.request_id = R.request_id group by P.partner_id
----------------------------------------------------------------------------------
//при условии что result заполняется 1 если кредит подтвержден и 0 во всех остальных случаях

select *all_parametrs,
        R.request_state,
        RR.response_answer from R
left join P on P.partner_id = R.partner_id
left join RR on RR.request_id = R.request_id where P.partner_id
----------------------------------------------------------------------------------
//*all_parametrs - все параметры заявки