package Thread.threadLocal;


import java.util.Random;

class House {
    int saleCount = 0;
    
    public synchronized void saleHouse() {
        saleCount++;
    }
    
    ThreadLocal<Integer> saleVolume = ThreadLocal.withInitial(() -> 0);
    
    public void saleVolumeByThreadLocal() {
        saleVolume.set(1 + saleVolume.get());
    }
}

public class ThreadLocalDemo {
    
    
    public static void main(String[] args) {
        House house = new House();

        for (int i = 1; i <= 5; i++) {
            new Thread(() -> {
                int size = new Random().nextInt(5) + 1;
                System.out.println(size);
                
                try {
                    for (int j = 1; j<= size; j++) {
                        house.saleHouse();
                        house.saleVolumeByThreadLocal();
                    }
                    System.out.println("线程" + Thread.currentThread().getName() + "卖出" + house.saleVolume.get());
                } finally {
                    house.saleVolume.remove();
                }
            }).start();
        }

        try {
            Thread.sleep(200);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        System.out.println("总数：" + house.saleCount);
        
    }
}
