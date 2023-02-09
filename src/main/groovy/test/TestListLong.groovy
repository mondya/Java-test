package test

class TestListLong {
    static void main(String[] args) {
        // 点位顺序
        List<Long> sortIds = [1,2,3,4]
        
        // 
        Long[] deviceIds = [1,2,2,3,3,3,4,1,2,3,4,1]

        List<List<String>> stringList = []
        String[] a = ["a", "b", "c", "d", "e", "f", "g", "h"    ]
        combinationSelect(a,0, new String[7], 0, stringList);
        println stringList.findAll{it.get(0) == 'a' && it.get(1) == 'b' && it.get(2) == 'c' && it.get(3) == 'd'}
    }
    
    static Long getLeft(List<Long> sortList, Integer index){
        Integer left = index - 1
        if (left >=0) {
            return sortList.get(left)
        } else {
            return null
        }
    }
    
    static Long getRight(List<Long> sortList, Integer index) {
        Integer right = index + 1
        if (right < sortList.size()) {
            return sortList.get(right)
        } else {
            return null
        }
    }

    public static void combinationSelect(String[] dataList, int dataIndex, String[] resultList, int resultIndex, List<List<String>> strList) {
        int resultLen = resultList.length; // 4
        int resultCount = resultIndex + 1; // 1
        if (resultCount > resultLen) { // 全部选择完时，输出组合结果
            //System.out.println(Arrays.asList(resultList));
            List<String> ids = resultList.clone().toList()
            strList.add(ids)
            return;
        }
        // 递归选择下一个
        for (int i = dataIndex; i < dataList.length + resultCount - resultLen; i++) { //dataIndex = 0
            resultList[resultIndex] = dataList[i]
            combinationSelect(dataList, i + 1, resultList, resultIndex + 1,strList)
        }

    }
}
