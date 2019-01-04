package com.muggle.poseidon.service;

import com.muggle.poseidon.base.ResultBean;
import com.muggle.poseidon.model.PoseidonGrantedAuthority;

import java.util.List;

/**
 * PoseidonGrantedAuthority的服务接口
 * 
 * @author 
 *
 */
public interface PoseidonGrantedAuthorityService {

	ResultBean update(PoseidonGrantedAuthority bean);

	Long count(PoseidonGrantedAuthority poseidonGrantedAuthority);

	ResultBean findAll(PoseidonGrantedAuthority authority);

	ResultBean insert(List<PoseidonGrantedAuthority> authorityList);

	ResultBean delete(String id);
}
