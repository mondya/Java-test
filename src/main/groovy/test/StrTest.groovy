package test

import com.alibaba.fastjson2.JSONArray
import com.alibaba.fastjson2.JSONObject

class StrTest {
    static void main(String[] args) {
        String json = """{
    "syncAction": "org_suite_auth",
    "auth_corp_info": {
        "auth_channel": "",
        "auth_channel_type": "",
        "auth_level": 1,
        "corp_logo_url": "http://url.com",
        "corp_name": "浩倡测试企业申请认证",
        "corpid": "dingxxxxxxxxxxxxxx",
        "industry": "信息技术咨询",
        "invite_code": "000000",
        "invite_url": "http://url.com",
        "is_authenticated": true,
        "license_code": "xxx"
    },
    "auth_info": {
        "agent": [{
            "admin_list": ["aaaa", "bbbb"],
            "agent_name": "Demo",
            "agentid": 16000,
            "appid": 1234,
            "logo_url": "http://url.png"
        }]
    },
    "auth_user_info": {
        "userId": "xxxx"
    },
    "auth_scope": {
        "errcode": 0,
        "condition_field": [],
        "auth_user_field": ["position", "jobnumber", "avatar", "deviceId"],
        "auth_org_scopes": {
            "authed_user": [],
            "authed_dept": [1]
        },
        "errmsg": "ok"
    },
    "permanent_code": "xxxxxxxxxxxxx",
    "ch_permanent_code": "xxxxxxxxxxxxxx"
}"""
        JSONObject jo = JSONObject.parseObject(json)
        
        
        switch (jo.syncAction){
            case 'org_suite_auth':
                JSONObject authInfo = jo.getJSONObject('auth_info')
                JSONArray agentList = authInfo.getJSONArray("agent")

                JSONObject agent = agentList.getJSONObject(0)
                Long agentId = agent.agentid as Long
                println agentId
                break
        }
    }
}
