/**
 *
 */

/**
 * @author b1014246
 *
 */
public class part01 {
	static String name = "すけさん";	// プレイヤーの名前
	static int lv = 30;			// プレイヤーのレベル
	static int hp = 30;
	static int gold = 50000;		// 初期所持金

	public static void main( String[] args) throws java.io.IOException {

		Console.PutJyosyou();				// 序章を表示

		Console.putCommand();				// コマンドを表示

		if(hp <= 0) {
			return;						// プログラムを終了する
		}

		// 魔王を倒しに行く
		if( lv < 40 ){				// レベルが40未満の場合
			Console.PutGameOver();			// ゲームオーバー画面の表示
		}
		else{						// レベルが40以上の場合
			Console.PutGameClear();			// レベルに応じたゲームクリアの画面の表示
		}
	}
}
