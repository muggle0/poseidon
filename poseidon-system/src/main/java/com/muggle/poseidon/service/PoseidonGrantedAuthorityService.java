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

	/**
	 * 新增或修改PoseidonGrantedAuthority中属性值
	 *
	 * @param bean
	 * @return
	 */
	ResultBean update(PoseidonGrantedAuthority bean);


	/**
	 * 通过PoseidonGrantedAuthority的id删除PoseidonGrantedAuthority
	 *
	 * @return
	 */
	ResultBean delete(List<String> ids);

	/**
	 * 通过PoseidonGrantedAuthority的id获得PoseidonGrantedAuthority对象
	 *
	 * @return
	 */
	ResultBean show(PoseidonGrantedAuthority bean);

	/**
	 * 获得PoseidonGrantedAuthority数据集
	 *
	 * @return
	 */
	ResultBean query(PoseidonGrantedAuthority bean);

	/**
	 * 导出PoseidonGrantedAuthority的数据
	 *
	 * @return
	 */
	ResultBean export(PoseidonGrantedAuthority bean);

	Long count(PoseidonGrantedAuthority poseidonGrantedAuthority);
}
