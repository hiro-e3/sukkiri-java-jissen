public class Main {
    public static void main(String[] args) {
        var box = new StrongBox<String>(KeyType.BUTTON);
        box.put("Hello, world!");
        for (int i = 0; i < 10_000 - 1; i++) {
            if(box.get() != null) {
                throw new AssertionError("ボタン式の金庫は、10,000回押すまで中身が取り出せないはず！");
            }
        }

        var item = box.get();
        if (!item.equals("Hello, world!")) {
            throw new AssertionError("中身あるはず！");
        } else {
            System.out.println("中身は" + item + "です。");
        }
    }
}
