package com.carapp.carscrapordermanager.vo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.carapp.carscrapordermanager.pojo.User;

public class UserVO extends User {

    private Integer roleId;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

	public UserVO(Integer roleId) {
		super();
		this.roleId = roleId;
	}
    
    
    
	
	public static void main(String[] args) {
		List list = new ArrayList<UserVO>();
		UserVO vo1 = new UserVO(1);
		UserVO vo2 = new UserVO(2);
		UserVO vo3 = new UserVO(3);
		list.add(vo1);
		list.add(vo2);
		list.add(vo3);
		List<UserVO> list2 = new ArrayList<UserVO>(list);
		Iterator<UserVO> iterator = list.iterator();
		while(iterator.hasNext()){
			UserVO vo = iterator.next();
			vo.setRoleId(vo.getRoleId()+1);
			iterator.remove();
			
		}
		
		for(UserVO vo:list2){
			
			System.out.println(vo.getRoleId());
		}
		
		
		
		
	}

	@Override
	public String toString() {
		return "UserVO [roleId=" + roleId + "]";
	}
}
