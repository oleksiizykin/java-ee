package bug_9;


//????????????)))
public class CacheProblem {
    String cache;

    public static void main(String[] args) {
        final CacheProblem cacheProblem = new CacheProblem();
        cacheProblem.setCache("cache");
        cacheProblem.fullCacheInformation(cacheProblem.getCache());
        System.out.println(cacheProblem.cache.equals("cache"));//hould be true, please provide few variants to fix this problem,

        /* Чтобы сравнение с "cache" было равно true, нужно:
        *1. У объекта cacheProblem вызвать сеттер setCache и проинициализировать "cache".
        *2. Проинициализировать через сеттер setCash любым значением, в методе fullCacheInformation
        *  к локальной переменной cashe дописать this, чтобы она было глобальной и изменить значение "cacheInfo" на "cache"
        * */
    }


    public void fullCacheInformation(String cache) {
        this.cache = "cache"/*Info*/;
    }

    public String getCache() {
        return cache;
    }

    public void setCache(String cache) {
        this.cache = cache;
    }
}
