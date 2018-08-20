package com.briup.estore.service.interfaces;

import com.briup.estore.common.bean.Line;
import com.briup.estore.common.exception.EstoreCommonException;



public interface ILineService {

	Line findByBookid(Integer id)throws EstoreCommonException;
	
}
