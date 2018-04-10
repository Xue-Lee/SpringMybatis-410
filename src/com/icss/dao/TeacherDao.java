package com.icss.dao;

import com.icss.entity.Teacher;

public interface TeacherDao {
	public Teacher findTeacherById(String tid);
	public Teacher showTeacher(String tid);
}
