package utils

import java.security.MessageDigest

class MD5Utils {

    static void main(String[] args) {
        Long stamp = System.currentTimeMillis()
        String s = stringToMd5("rmgepOTEwMRmkCiGijx5ISvLZW9I9UfaVPaIZI6Yp6xiYt70Sz1v6Fyyb0VTj1xN"+stamp+"116103")
        println stamp
        println s
    }
    
    public static String stringToMd5(String string){
        byte[] hash
        try {
            hash = MessageDigest.getInstance("MD5").digest(string.getBytes("utf-8"))
        } catch (Exception e){
            e.printStackTrace()
            return null
        }
        
        StringBuilder hex = new StringBuilder(hash.length * 2)
        
        for (byte b: hash){
            if ((b & 0xFF) < 0x10)
                hex.append(0)
            hex.append(Integer.toHexString(b & 0xFF))
        }
        
        return hex.toString()
    }
}
