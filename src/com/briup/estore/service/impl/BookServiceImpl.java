package com.briup.estore.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.estore.common.bean.Book;
import com.briup.estore.common.bean.Type;
import com.briup.estore.common.exception.EstoreCommonException;
import com.briup.estore.dao.IBookDao;
import com.briup.estore.service.interfaces.IBookService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;


/**
 * 书籍信息Service
 * 
 * @author danmo
 * @date 2017-7-31
 *
 */
@Service
public class BookServiceImpl implements IBookService {

	@Autowired
	private IBookDao bookDao;
	
	@Override
	public List<Book> getAllBooks() throws EstoreCommonException {
		
		List<Book> books = bookDao.queryAll();
		if (books!=null && books.size() > 0) {
			return books;
		}
		throw EstoreCommonException.getException(404);
	}

	@Override
	public Type findByBookId(Integer id) throws EstoreCommonException {

		if (id.equals("")) {
			throw EstoreCommonException.getException(401);
		}
		Type type = bookDao.queryByBookId(id);
		if (type ==null) {
			throw EstoreCommonException.getException(404);
		}
		return type;
	}
	
	
	@Override
	public List<Type> findType() throws EstoreCommonException {

		List<Type> types = bookDao.findType();
		if (types != null && types.size() > 0) {
			return types;
		}
		throw EstoreCommonException.getException(404);
	}
	
	@Override
	public Book findById(Integer id) throws EstoreCommonException {

		if (id.equals("")) {
			throw EstoreCommonException.getException(401);
		}
		Book book = bookDao.queryById(id);
		if (book == null) {
			throw EstoreCommonException.getException(404);
		}
		return book;
	}


	@Override
	public PageInfo<Book> findAllBookWithPage(int page,int rows) throws EstoreCommonException {

		PageHelper.startPage(page, rows);
		List<Book> books = bookDao.queryAll();
		if (books != null && books.size() > 0) {
			return new PageInfo<Book>(books);
		}
		throw EstoreCommonException.getException(404);
	}
	
	@Override
	public PageInfo<Book> selectBookByEx(Map<String, Object> map, int page, int rows)
			throws EstoreCommonException {

		PageHelper.startPage(page, rows);
		List<Book> books = bookDao.selectBook(map);
		if (books != null && books.size() > 0) {
			return new PageInfo<Book>(books);
		}
		throw EstoreCommonException.getException(404);
	}

	@Override
	public Type getTypeByName(String name) throws EstoreCommonException {
		if (StringUtils.isNotBlank(name)) {
			Type type = bookDao.getTypeByName(name);
			return type;
		}
		throw EstoreCommonException.getException(401);
	}

	
}
