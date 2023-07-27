import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		System.out.println("**猫集め**");

		Scanner scan = new Scanner(System.in);
		List<Cat> list = new ArrayList<Cat>();
		while (true) {
			System.out.println("1:集める 2:遊ぶ 3:終了>>");
			int select = scan.nextInt();
			switch (select) {
			case 1:

				String[] str = { "白", "黒", "茶トラ" };
				int num = new Random().nextInt(str.length);
				System.out.println(str[num] + "猫をみつけた！");
				System.out.println("この猫に名前をつけてください>>");
				String s = new Scanner(System.in).nextLine();
				Cat c = new Cat(s, str[num]);
				System.out.println(c.name + "が仲間に加わった！");
				list.add(c);
				break;

			case 2:
				if (list.size() < 0) {
					try {
						for (int i = 0; i < list.size(); i++) {
							System.out.println(i + "・・・" + list.get(i).name + "[" + list.get(i).color + "]" + "("
									+ list.get(i).friendly + ")");
						}
						System.out.println("どの猫と遊びますか?>>");
						int select2 = scan.nextInt();
						System.out.println(list.get(select2).name + "と遊んだ");
						list.get(select2).friendly++;
						System.out.println(list.get(select2).name + "との親密度が上がった！");
						break;
					} catch (Exception e) {
						System.out.println("要素数に無い番号です。");
						return;
					}
				} else {
					System.out.println("まだ猫がいません");
				}

			case 3:
				System.out.println("***結果***");
				for (int i = 0; i < list.size(); i++) {
					System.out.println(i + "・・・" + list.get(i).name + "[" + list.get(i).color + "]" + "("
							+ list.get(i).friendly + ")");
				}
				break;
			}
			System.out.println("またあそんでね！おしまい");
		}

	}

}
