package com.muggle.poseidon.service;

import com.muggle.poseidon.base.ResultBean;
import com.muggle.poseidon.entity.PoseidonBlackList;

import java.util.List;
import java.util.Optional;

/**
 * PoseidonBlackList的服务接口
 * 
 * @author 
 *
 */
public interface PoseidonBlackListService {


	ResultBean update(PoseidonBlackList bean);


	/**
	 * 通过PoseidonBlackList的id删除PoseidonBlackList
	 *
	 * @return
	 */
	ResultBean delete(String id);

	/**
	 * 通过PoseidonBlackList的id获得PoseidonBlackList对象
	 *
	 * @return
	 */
	Optional<PoseidonBlackList> findOne(String id);

	/**
	 * 获得PoseidonBlackList数据集
	 *
	 * @return
	 */
	List<PoseidonBlackList> find(PoseidonBlackList bean);

	long count(PoseidonBlackList bean);

	ResultBean insert (List<PoseidonBlackList> lists);


}
