package hwod.mini;

/**
 * @author dongzhenxun
 * @date 2025/10/29 下午8:33
 * @description 描述
 */
public class FizzBuzzWhizzGame {

    private final handleFBWG handleFBWG;

    public FizzBuzzWhizzGame(int i) {
        // 根据传入的 i 值，通过反射加载对应的实现类：
        String className = "hwod.mini.FBWGSolution" + i;
        try {
            Class<?> cls = Class.forName(className);
            Object obj = cls.getDeclaredConstructor().newInstance();
            if (!(obj instanceof handleFBWG)) {
                throw new IllegalArgumentException(className + " does not implement handleFBWG");
            }
            this.handleFBWG = (handleFBWG) obj;
        } catch (ClassNotFoundException e) {
            throw new IllegalArgumentException("No solution class found for index: " + i, e);
        } catch (ReflectiveOperationException e) {
            throw new RuntimeException("Failed to instantiate solution class: " + className, e);
        }
    }

    /**
     * 代理到具体实现
     */
    public String play(int num) {
        if (this.handleFBWG == null) {
            throw new IllegalStateException("handler not initialized");
        }
        return this.handleFBWG.handle(num);
    }
}
