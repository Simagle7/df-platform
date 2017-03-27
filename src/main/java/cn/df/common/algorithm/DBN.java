package cn.df.common.algorithm;

import cn.df.domain.specimen.Patient;

import java.text.DecimalFormat;
import java.util.Map;

/**
 * Created by KatyBaby on 2017/3/27.
 * DBN 算法
 */
public class DBN {
//    @Autowired
//    private IPatientDAO patientDAO;
    private  DecimalFormat df = new java.text.DecimalFormat("#.###");

    public  String getProbability(Patient patient, Map<String,Object> params){
        double v = Math.random();
        if(patient.getProbability() != null){
            return df.format(patient.getProbability());
        }
        else {
//            patientDAO.updateProbability(v,patient.getId());
            return df.format(v);
        }
    }
}
