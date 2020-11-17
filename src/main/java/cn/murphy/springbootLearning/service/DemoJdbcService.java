package cn.murphy.springbootLearning.service;

import cn.murphy.springbootLearning.pojo.Demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DemoJdbcService {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    public Demo getById(Long id){
        String sql = " select * from demo where id = ? ";
        RowMapper<Demo> mapper = new BeanPropertyRowMapper<>(Demo.class);
        return  jdbcTemplate.queryForObject(sql, mapper,id);
    }


//    public static void main(String[] args) {
//        List<String> list = new ArrayList<String>();
//        list.add("D4556-139713");
//        list.add("C9999-30000");
//        list.add("C4671-40000");
//        list.add("C2923-20000");
//        list.add("C1398-20000");
//        list.add("D2023-20000");
//        list.add("D1268-30000");
//        list.add("C2622-10488");
//        list.add("D1588-31590");
//        list.add("C9715-20000");
//        list.add("C1688-10000");
//        list.add("C9137-20000");
//        list.add("C6092-12038");
//        list.add("C1025-10000");
//        list.add("D5677-20000");
//        list.add("C1153-0");
//        list.add("C2272-0");
//        list.add("D0957-15000");
//        list.add("C8500-10000");
//        list.add("C2593-3500");
//        list.add("D2259-10000");
//        list.add("C5156-10000");
//        list.add("D8814-11000");
//        list.add("C9774-10000");
//        list.add("C2029-15298");
//        list.add("D6538-10000");
//        list.add("E1679-10000");
//        list.add("D1550-10000");
//        list.add("D4166-10000");
//        list.add("C4676-10000");
//        list.add("C2606-10000");
//        list.add("C1901-4360");
//        list.add("D5103-14426");
//        list.add("D5564-14405");
//        list.add("C6223-10000");
//        list.add("C4871-4000");
//        list.add("C8116-4000");
//        list.add("C1403-3540");
//        list.add("C1397-3335");
//        list.add("C3061-3000");
//        list.add("D1255-0");
//        list.add("D2519-0");
//        list.add("C2573-0");
//        list.add("D2667-0");
//        list.add("C1548-5473");
//        list.add("C4059-5433");
//        list.add("D3443-5421");
//        list.add("C8997-5126");
//        list.add("C9931-4496");
//        list.add("C3068-4000");
//        list.add("C4739-5200");
//        list.add("D5074-5100");
//        list.add("C8568-5100");
//        list.add("C3309-0");
//        list.add("D5461-5000");
//        list.add("D5575-3030");
//        list.add("C8682-2767");
//        list.add("C9139-2707");
//        list.add("D1355-2252");
//        list.add("C4717-4184");
//        list.add("D8812-4122");
//        list.add("C8481-4012");
//        list.add("C6594-3902");
//        list.add("C2190-3272");
//        list.add("D0191-8256");
//        list.add("C6539-3246");
//        list.add("C7235-3242");
//        list.add("C4654-3202");
//        list.add("C4408-3146");
//        list.add("D3149-2998");
//        list.add("D2584-2977");
//        list.add("C4706-2918");
//        list.add("C9445-2884");
//        list.add("C5074-2846");
//        list.add("C3690-2785");
//        list.add("C1092-2685");
//        list.add("C8458-2545");
//        list.add("C2161-2537");
//        list.add("C7201-2517");
//        list.add("C4042-7482");
//        list.add("C6461-2464");
//        list.add("C9456-2438");
//        list.add("C6588-2390");
//        list.add("C1124-2355");
//        list.add("C3963-2281");
//        list.add("C3591-2199");
//        list.add("C4996-2150");
//        list.add("C3034-2118");
//        list.add("C7392-2114");
//        list.add("C1813-1943");
//        list.add("C6296-1925");
//        list.add("D5176-1830");
//        list.add("C0524-1750");
//        list.add("D0187-1743");
//        list.add("C5344-6642");
//        list.add("C9357-1490");
//        list.add("C0511-1459");
//        list.add("C9886-1445");
//        list.add("C0667-1419");
//        list.add("C6943-1377");
//        list.add("C3332-1299");
//        list.add("D0124-1286");
//        list.add("D5356-1184");
//        list.add("C9627-1096");
//        list.add("C6722-1086");
//        list.add("C2717-1007");
//        list.add("C1164-5950");
//        list.add("C0558-948");
//        list.add("D0033-936");
//        list.add("D4635-928");
//        list.add("D0111-926");
//        list.add("D5143-907");
//        list.add("C2023-872");
//        list.add("D8650-872");
//        list.add("C3401-861");
//        list.add("D9469-836");
//        list.add("C3013-688");
//        list.add("C2948-670");
//        list.add("C8970-653");
//        list.add("C0488-636");
//        list.add("D2101-606");
//
//        for(String str : list){
//            String[]  ar = str.split("-");
//            //ar[0]
//            StringBuilder sb = new StringBuilder("");
//            sb.append("INSERT INTO `hc_prod`.`customer_score_trans_tab`( `customer_no`, `change_type`, `change_score`, `change_person`, `change_time`, `change_ip`, `change_content`, `change_detail`, `change_src`, `part_no`, `rowid`, `rowversion`)");
//            sb.append(" VALUES ");
//            sb.append(" ('"+ar[0]+"', 'Outdate', -"+ar[1]+", '"+ar[0]+"', now(), '127.0.0.1', '会员【"+ar[0]+"】过期，扣除积分【"+ar[1]+"】', '', NULL, NULL, uuid(), now); ");
//            System.out.println(sb.toString());
//
//
//            StringBuffer sf = new StringBuffer("");
//
//            sf.append("update customer_score_tab set total_score = total_score-"+ar[1]+",left_score = left_score-"+ar[1]+" where customer_no = '"+ar[0]+"');");
//            System.out.println(sf.toString());
//
//            System.out.println("\n\n");
//
//
//
//
//
//        }
//
//
//
//
//
//    }

}
