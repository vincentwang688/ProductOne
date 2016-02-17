package com.product.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import com.product.dao.interfaces.UserDaoInterface;
import com.product.exception.DAOException;
import com.product.jdbc.util.JDBCUtils;
import com.product.model.UserInfo;

public class UserInfoDao implements UserDaoInterface {

	public int addUser(UserInfo user) {
		Connection con = null;
		PreparedStatement ps = null;
		int i = 0;
		try {
			con = JDBCUtils.getConnection();
			String sql = "insert into user_info(username, password) values (?, ?)";
			ps = con.prepareStatement(sql);

			ps.setString(1, user.getUserName());
			ps.setString(2, user.getPassword());
			i = ps.executeUpdate();

		} catch (SQLException e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			JDBCUtils.release(null, ps, con);
		}
		return i;
	}

	public int deleteUser(String userName) {
		Connection con = null;
		PreparedStatement ps = null;
		int i = 0;
		try {
			con = JDBCUtils.getConnection();
			String sql = "delete from user_info where username = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, userName);

			i = ps.executeUpdate();

		} catch (SQLException e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			JDBCUtils.release(null, ps, con);
		}

		return i;
	}

	public int updateUser(UserInfo user) {
		Connection con = null;
		PreparedStatement ps = null;
		int i = 0;
		try {
			con = JDBCUtils.getConnection();
			String sql = "update user_info set password = ? where username = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, user.getPassword());
			ps.setString(2, user.getUserName());

			i = ps.executeUpdate();

		} catch (SQLException e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			JDBCUtils.release(null, ps, con);
		}

		return i;
	}

	public UserInfo findUser(String userName) {
		Connection con = null;
		PreparedStatement ps = null;
		UserInfo user = null;
		ResultSet rs = null;
		try {
			con = JDBCUtils.getConnection();
			String sql = "select username,password from user_info where username = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, userName);

			rs = ps.executeQuery();
			user = new UserInfo();
			while (rs.next()) {
				user.setUserName(rs.getString(1));
				user.setPassword(rs.getString(2));
			}
		} catch (SQLException e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			JDBCUtils.release(rs, ps, con);
		}

		return user;
	}

	public Set<UserInfo> findAll() {
		Connection con = null;
		PreparedStatement ps = null;
		UserInfo user = null;
		ResultSet rs = null;
		Set<UserInfo> set = null;
		try {
			con = JDBCUtils.getConnection();
			String sql = "select username,password from user_info";
			ps = con.prepareStatement(sql);
			set = new HashSet<UserInfo>();
			rs = ps.executeQuery();
			while (rs.next()) {
				user = new UserInfo();
				user.setUserName(rs.getString(1));
				user.setPassword(rs.getString(2));
				set.add(user);
			}
		} catch (SQLException e) {
			throw new DAOException(e.getMessage(), e);
		} finally {
			JDBCUtils.release(rs, ps, con);
		}

		return set;
	}
}
