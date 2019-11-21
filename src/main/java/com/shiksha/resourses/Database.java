package com.shiksha.resourses;

import java.sql.*;

import com.shiksha.main.Objects;

public class Database {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	Connection conn;
	Statement stmt;

	public void closeConnection() {
		try {
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void closeConnection(Objects obj) {
		try {
			if (obj.getConnection() != null)
				obj.getConnection().close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ResultSet executeDbQuery(String query, Objects obj) throws Exception {
		ResultSet rsObj = null;
		// // Code for Data pooling
		try {
			PreparedStatement pstmtObj = null;
			pstmtObj = obj.getConnection().prepareStatement(query);
			rsObj = pstmtObj.executeQuery();
		}

		catch (Exception e) {
			throw e;
		}
		/*
		 * try { // Class.forName("com.mysql.jdbc.Driver"); Connection conn =
		 * DriverManager.getConnection(obj.getdbURL(), obj.getdbUserName(),
		 * obj.getdbPassword()); Statement stmt = conn.createStatement(); for
		 * (int i = 0; i < 1; i++) { rs = stmt.executeQuery(query); if
		 * (getCountOfResultSet(rs) == 0) Thread.sleep(1000); else break; }
		 * 
		 * } catch (Exception e) { throw e; }
		 */
		return rsObj;
	}

	public ResultSet CourseListingLocation(String course_id, Objects obj)
			throws Exception {
		ResultSet rs = null;
		String query = "select course.*,loc.*,institute.name as insname,loc.is_main,st.state_name,cct.city_name,lct.localityName,loc2.city_id,loc2.locality_id  from shiksha_courses course "
				+ " join shiksha_institutes institute on course.primary_id = institute.listing_id join shiksha_courses_locations loc "
				+ "on loc.course_id = course.course_id join shiksha_institutes_locations loc2 on loc.listing_location_id = loc2.listing_location_id"
				+ " join stateTable st on st.state_id = loc2.state_id join countryCityTable cct on cct.city_id = loc2.city_id left join localityCityMapping lct"
				+ " on lct.localityId = loc2.locality_id  where course.course_id ="
				+ course_id
				+ " and course.status = 'live' and institute.status = 'live' and loc.status = 'live' ;";
		try {
			rs = executeDbQuery(query, obj);
		} catch (Exception e) {
			throw e;
		}
		return rs;
	}

	public ResultSet CourseTypeInformation(String course_id, Objects obj)
			throws Exception {
		ResultSet rs = null;
		String query = "select * from shiksha_courses_type_information cti join base_attribute_list bal on bal.value_id = cti.course_level  or bal.value_id = cti.credential where  course_id = "
				+ course_id
				+ " and primary_hierarchy =1 and cti.status = 'live';";
		try {
			rs = executeDbQuery(query, obj);
		} catch (Exception e) {
			throw e;
		}
		return rs;
	}

	public ResultSet getInfotuser(String email, Objects obj) throws Exception {
		ResultSet rs = null;
		String query = "";
		query = "select * from tuser where email = '" + email
				+ "' order by 1 desc;";
		try {
			rs = executeDbQuery(query, obj);
		} catch (Exception e) {
			throw e;
		}
		return rs;
	}

	public ResultSet getInfouserResponseLocationAffinity(String email,
			Objects obj) throws Exception {
		ResultSet rs = null;
		String query = "";
		query = "select b.* from tuser a join userResponseLocationAffinity b"
				+ " on a.userid = b.userid  where a.email = '" + email
				+ "' order by 1 desc;";
		try {
			rs = executeDbQuery(query, obj);
		} catch (Exception e) {
			throw e;
		}
		return rs;
	}

	public ResultSet getInfoComparePage_Tracking(String email, Objects obj)
			throws Exception {
		ResultSet rs = null;
		String query = "";
		Thread.sleep(5000);
		query = "select t.* from ComparePage_Tracking t join tuser u"
				+ " on u.userid = t.userId where email = '" + email
				+ "' order by 1 desc limit 1;";
		try {
			rs = executeDbQuery(query, obj);
		} catch (Exception e) {
			throw e;
		}
		return rs;
	}

	public Boolean getInfotresponsedata(String email, Objects obj)
			throws Exception {
		Boolean flag = false;
		ResultSet rs = null;
		ResultSet rs1 = null;
		String query = "";
		query = "select * from temp_response_queue a join tuser c on c.userid = a.user_id where c.email = '"
				+ email + "' order by 1 desc limit 1;";
		try {
			rs = executeDbQuery(query, obj);
			if (getCountOfResultSet(rs) == 1) {
				while (rs.next()) {
					String user_id = rs.getString("userid");
					String action = rs.getString("action_type");
					query = "select * from tresponsedata where action = '"
							+ action + "';";
					rs1 = executeDbQuery(query, obj);
					if (getCountOfResultSet(rs1) == 1) {
						while (rs1.next()) {
							if (rs1.getString("userIds").contains(user_id)) {
								flag = true;

							}
						}
					}
				}
			}

		} catch (Exception e) {
			throw e;
		}
		return flag;
	}

	public ResultSet getInforesponseLocationTable(String email, Objects obj)
			throws Exception {
		ResultSet rs = null;
		ResultSet rs1 = null;
		String query = "";
		query = "select a.* from tempLMSTable a join tuser c on c.userid = a.userid where c.email = '"
				+ email + "' order by 1 desc limit 1;";
		try {
			rs = executeDbQuery(query, obj);
			if (getCountOfResultSet(rs) == 1) {
				while (rs.next()) {
					String id = rs.getString("id");
					query = "select * from responseLocationTable where responseId = "
							+ id + ";";
					rs1 = executeDbQuery(query, obj);

				}
			}

		} catch (Exception e) {
			throw e;
		}
		return rs1;
	}

	public ResultSet getInfotempLMSTable(String email, Objects obj)
			throws Exception {
		ResultSet rs = null;
		String query = "";
		query = "select * from tempLMSTable where email = '" + email
				+ "' order by 1 desc limit 1;";
		try {
			rs = executeDbQuery(query, obj);
		} catch (Exception e) {
			throw e;
		}
		return rs;
	}

	public String OTPVerification(String mobno, Objects obj) throws Exception {
		String data = "";
		ResultSet rs;
		String query = "select * from OTPVerification where mobile = " + mobno
				+ " and status = 'sent'  order by 1 desc limit 1;";
		try {
			rs = executeDbQuery(query, obj);
			if (getCountOfResultSet(rs) == 1) {
				while (rs.next()) {
					data = rs.getString("OTP");
				}
			}
		} catch (Exception e) {
			throw e;
		}
		return data;
	}

	public ResultSet CourseRecogition(String course_id, Objects obj)
			throws Exception {
		ResultSet rs = null;
		String query = "select * from shiksha_courses_additional_info info "
				+ "join base_attribute_list base on base.value_id = info.attribute_value_id "
				+ " where info.course_id = "
				+ course_id
				+ " and info.info_type = 'recognition' and info.status = 'live' and base.status = 'live' order by value_name;";
		try {
			rs = executeDbQuery(query, obj);
		} catch (Exception e) {
			throw e;
		}
		return rs;
	}

	public ResultSet getInfotUserInterest(String email, Objects obj)
			throws Exception {
		ResultSet rs = null;
		String query = "";
		query = "select b.* from tuser a join tUserInterest b on a.userid = b.userId where email = '"
				+ email + "' and status = 'live' order by 1 desc;";
		try {
			rs = executeDbQuery(query, obj);
		} catch (Exception e) {
			throw e;
		}
		return rs;
	}

	public ResultSet getInfotempLmsRequest(String email, Objects obj)
			throws Exception {
		ResultSet rs = null;
		String query = "";
		query = "select b.* from tuser a join tempLmsRequest b on a.userid = b.userId where email = '"
				+ email + "' order by 1 desc limit 1;";
		try {
			rs = executeDbQuery(query, obj);
		} catch (Exception e) {
			throw e;
		}
		return rs;
	}

	public ResultSet getInfotUserCourseSpecialization(String email, Objects obj)
			throws Exception {
		ResultSet rs = null;
		String query = "";
		query = "select c.* from tuser a join tUserInterest b on a.userid = b.userId "
				+ " join tUserCourseSpecialization c on c.interestId  = b.interestId "
				+ "where email = '"
				+ email
				+ "' and b.status = 'live' order by 1 desc;";
		try {
			rs = executeDbQuery(query, obj);
		} catch (Exception e) {
			throw e;
		}
		return rs;
	}

	public ResultSet getInfotUserAttributes(String email, Objects obj)
			throws Exception {
		ResultSet rs = null;
		String query = "";
		query = "select c.* from tuser a join tUserInterest b on a.userid = b.userId "
				+ " join tUserAttributes c on c.interestId  = b.interestId "
				+ "where email = '"
				+ email
				+ "' and c.status = 'live' order by 1 desc;";
		try {
			rs = executeDbQuery(query, obj);
		} catch (Exception e) {
			throw e;
		}
		return rs;
	}

	public ResultSet getInfotuserflag(String email, Objects obj)
			throws Exception {
		ResultSet rs = null;
		String query = "";
		query = "select * from tuser a join tuserflag b on a.userid = b.userId "
				+ "where email = '" + email + "' order by 1 desc;";
		try {
			rs = executeDbQuery(query, obj);
		} catch (Exception e) {
			throw e;
		}
		return rs;
	}

	public ResultSet getInfotUserPref(String email, Objects obj)
			throws Exception {
		ResultSet rs = null;
		String query = "";
		query = "select * from tuser a join tUserPref b on a.userid = b.userId "
				+ "where email = '"
				+ email
				+ "' and b.Status = 'live' order by 1 desc;";
		try {
			rs = executeDbQuery(query, obj);
		} catch (Exception e) {
			throw e;
		}
		return rs;
	}

	public ResultSet getInfouser_response_profile(String email, Objects obj)
			throws Exception {
		ResultSet rs = null;
		String query = "";
		query = "select * from tuser a join user_response_profile b on a.userid = b.user_id "
				+ "where email = '"
				+ email
				+ "' and b.Status = 'live' order by  b.id desc limit 1;";
		try {
			rs = executeDbQuery(query, obj);
		} catch (Exception e) {
			throw e;
		}
		return rs;
	}

	public ResultSet getInfolatestUserResponseData(String email, Objects obj)
			throws Exception {
		ResultSet rs = null;
		String query = "";
		query = "select * from tuser a join latestUserResponseData b on a.userid = b.userId "
				+ "where email = '" + email + "' order by 1 desc limit 1;";
		try {
			rs = executeDbQuery(query, obj);
		} catch (Exception e) {
			throw e;
		}
		return rs;
	}

	public ResultSet getInfotUserEducation(String email, Objects obj)
			throws Exception {
		ResultSet rs = null;
		String query = "";
		query = "select * from tuser a join tUserEducation b on a.userid = b.userId "
				+ "where email = '"
				+ email
				+ "' and b.Status = 'live' order by 1 desc limit 1;";
		try {
			rs = executeDbQuery(query, obj);
		} catch (Exception e) {
			throw e;
		}
		return rs;
	}

	public ResultSet getInfotemp_response_queue(String email, Objects obj)
			throws Exception {
		ResultSet rs = null;
		String query = "";
		query = "select * from tuser a join temp_response_queue b on a.userid = b.user_id "
				+ "where email = '" + email + "' order by b.id desc limit 2;";
		try {
			rs = executeDbQuery(query, obj);
		} catch (Exception e) {
			throw e;
		}
		return rs;
	}

	public ResultSet CourseMedium(String course_id, Objects obj)
			throws Exception {
		ResultSet rs = null;
		String query = "select * from shiksha_courses_additional_info info "
				+ "join base_attribute_list base on base.value_id = info.attribute_value_id "
				+ " where info.course_id = "
				+ course_id
				+ " and info.info_type = 'instruction_medium' and info.status = 'live' and base.status = 'live' order by value_name = 'English' desc ,value_name asc;";
		try {
			rs = executeDbQuery(query, obj);
		} catch (Exception e) {
			throw e;
		}
		return rs;
	}

	public ResultSet DifficultyLevel(String course_id, Objects obj)
			throws Exception {
		ResultSet rs = null;
		String query = "select * from shiksha_courses c "
				+ "join base_attribute_list l on l.value_id = c.difficulty_level "
				+ "where c.course_id = " + course_id
				+ " and c.status = 'live' order by 1;";
		try {
			rs = executeDbQuery(query, obj);
		} catch (Exception e) {
			throw e;
		}
		return rs;
	}

	public ResultSet GetLisingUrl(String listing_id, Objects obj)
			throws Exception {
		ResultSet rs = null;
		String query = "select * from listings_main where listing_type_id = "
				+ listing_id
				+ " and listing_type in ('university_national','university') and status = 'live';";
		try {
			rs = executeDbQuery(query, obj);
		} catch (Exception e) {
			throw e;
		}
		return rs;
	}

	public ResultSet GetLocalities(String course_id, Objects obj)
			throws Exception {
		ResultSet rs = null;
		String query = "select * from shiksha_courses_locations c left join shiksha_institutes_locations i "
				+ "on c.listing_location_id = i.listing_location_id LEFT JOIN  localityCityMapping lct ON lct.localityId = i.locality_id "
				+ " JOIN countryCityTable cct ON cct.city_id = i.city_id  where course_id = "
				+ course_id + " and c.status = 'live' and i.status = 'live';";
		try {
			rs = executeDbQuery(query, obj);
		} catch (Exception e) {
			throw e;
		}
		return rs;
	}

	public ResultSet GetCourseStructure(String course_id, Objects obj)
			throws Exception {
		ResultSet rs = null;
		String query = "select * from shiksha_courses_structure_offered_courses where status = 'live'"
				+ " and course_id = " + course_id + ";";
		try {
			rs = executeDbQuery(query, obj);
		} catch (Exception e) {
			throw e;
		}
		return rs;
	}

	public ResultSet CourseFees(String course_id, String city, String locality,
			Objects obj) throws Exception {
		ResultSet rs = null;
		ResultSet rs1 = null;
		String query = "select cl.listing_location_id from shiksha_courses_locations cl join shiksha_institutes_locations il on il.listing_location_id = cl.listing_location_id "
				+ " where cl.course_id  ="
				+ course_id
				+ " and cl.status = 'live' and il.status = 'live'  ";
		if (city.length() > 0 && locality.length() > 0) {
			query = query + "and il.city_id =" + city
					+ " and il.locality_id = " + locality + ";";
		} else if (city.length() > 0) {
			query = query + "and il.city_id =" + city + ";";
		} else {
			query = query + "  and cl.is_main = 1 ;";
		}
		try {
			rs = executeDbQuery(query, obj);
			if (getCountOfResultSet(rs) == 1) {
				while (rs.next()) {
					String queryd = "select * from shiksha_courses_fees d join currency c on d.fees_unit = c.id where d.listing_location_id in ("
							+ rs.getString("listing_location_id")
							+ ") and d.course_id = "
							+ course_id
							+ " and status = 'live' order by category = 'general' desc;";
					rs1 = executeDbQuery(queryd, obj);
					if (getCountOfResultSet(rs1) == 0) {
						String queryi = "select * from shiksha_courses_fees d join currency c on d.fees_unit = c.id where d.listing_location_id in ("
								+ "-1"
								+ ") and d.course_id = "
								+ course_id
								+ " and status = 'live' order by category = 'general' desc;";
						rs1 = executeDbQuery(queryi, obj);

					}
				}
			}
		} catch (Exception e) {
			throw e;
		}
		return rs1;
	}

	public ResultSet BaseAttributeList(String value_Id, Objects obj)
			throws Exception {
		ResultSet rs = null;
		String query = "select * from base_attribute_list where value_id = "
				+ value_Id + ";";
		try {
			rs = executeDbQuery(query, obj);
		} catch (Exception e) {
			throw e;
		}
		return rs;
	}

	public ResultSet GetCourseList(Objects obj) throws Exception {
		ResultSet rs = null;
		String query = "select course_id from shiksha_courses where status = 'live'  order by 1 desc  limit 10;";
		try {
			rs = executeDbQuery(query, obj);
		} catch (Exception e) {
			throw e;
		}
		return rs;
	}

	public ResultSet courseTopSection(String course_id, String city,
			String locality, Objects obj) throws Exception {
		ResultSet rs = null;
		String query = "select course.*,loc.*,institute.name as insname,institute.accreditation,loc.is_main,st.state_name,cct.city_name,lct.localityName,loc2.city_id,loc2.locality_id  from shiksha_courses course "
				+ " join shiksha_institutes institute on course.primary_id = institute.listing_id join shiksha_courses_locations loc "
				+ "on loc.course_id = course.course_id join shiksha_institutes_locations loc2 on loc.listing_location_id = loc2.listing_location_id"
				+ " join stateTable st on st.state_id = loc2.state_id join countryCityTable cct on cct.city_id = loc2.city_id left join localityCityMapping lct"
				+ " on lct.localityId = loc2.locality_id  where course.course_id ="
				+ course_id
				+ " and course.status = 'live'  and loc2.status = 'live' and institute.status = 'live' and loc.status = 'live' ";
		if (city.length() > 0 && locality.length() > 0) {
			query = query + "and loc2.city_id =" + city
					+ " and loc2.locality_id = " + locality + ";";
		} else if (city.length() > 0) {
			query = query + "and loc2.city_id =" + city + ";";
		} else {
			query = query + "  and loc.is_main = 1 ;";
		}
		try {
			rs = executeDbQuery(query, obj);
		} catch (Exception e) {
			throw e;
		}
		return rs;
	}

	public int getCountOfResultSet(ResultSet rs) {
		int count = 0;
		try {
			if (rs.last()) {
				count = rs.getRow();
				rs.beforeFirst();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
}
