package com.ayovel.nian.test;

import com.ayovel.nian.dao.UserInfoDAO;
import com.ayovel.nian.modle.UserinfoDTO;

import java.sql.SQLException;

public class TestDB {
	
	public static void main(String args[]){
		 UserInfoDAO userdao = new UserInfoDAO();
		 try {
			UserinfoDTO user =userdao.queryUserInfoForID("18675520826");
			System.out.println(user.getId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		 
	}

}
