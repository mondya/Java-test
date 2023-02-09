package test

class TestSortString {
    static void main(String[] args) {
        List<String> stringList = ["1" ,"0"]
        
        println stringList.sort{- Long.parseLong(it)}
    }
}
