package test

import com.alibaba.fastjson2.JSONObject

class TestCase {

    static void main(String[] args) {
        String response = """    {"result": [
        {
            "auto_add_user": true,
            "create_dept_group": true,
            "dept_id": 3795,
            "name": "市场部",
            "parent_id": 1,
            "ext":[{"hello": "hello"}]
        },
        {
            "auto_add_user": true,
            "create_dept_group": true,
            "dept_id": 39996,
            "parent_id": 1,
            "name": "财务部"
        }
    ]}"""
        String json = """{"result": []}"""

        JSONObject jsonObject = JSONObject.parseObject(response)
        println jsonObject.result
        List<DingDept> deptList = jsonObject.result as List<DingDept>
        List<DingDeptV2> depts = []
        jsonObject.result.each {
                
            DingDeptV2 dept = new DingDeptV2()
            dept.name = it.name
            dept.dept_id = it.dept_id
            dept.create_dept_group = it.create_dept_group
            dept.auto_add_user = it.auto_add_user
            dept.parent_id = it.parent_id
            
            depts.add(dept)
        }
        println depts
    }
}
