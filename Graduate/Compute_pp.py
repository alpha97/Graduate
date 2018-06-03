#coding:utf-8
#计算困惑度确定Topic个数
import math


def compute(asdict,tw_dict,dt_dict):
    perp = 0.0
    sum_ln_pt = 0.0
    sum_t = 0.0
    sum_value = 0.0
    for i in range(len(asdict)):
        sum_t += len(asdict[i].split(" "))
        pt = 0.0
        for elem in asdict[i].split(" "):
            pz = 0.0
            t_id = int(elem.split(":")[0])
            for j in range(len(tw_dict)):

                p_tz = float(tw_dict[j].split("\t")[t_id])

                p_zd = float(dt_dict[i].split("\t")[j])
                pz += p_tz*p_zd
            pt += math.log(pz)
        sum_ln_pt += pt
    perp = math.pow(math.e,(-sum_ln_pt/sum_t))
    return perp

#print compute(asdict,tw_dict,dt_dict)