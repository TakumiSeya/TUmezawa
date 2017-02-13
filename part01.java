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
	public static void main( String[] args) throws java.io.IOException {

		PutJyosyou();				// 序章を表示

		putCommand();				// コマンドを表示

		if(hp <= 0) {
			return;						// プログラムを終了する
		}

		// 魔王を倒しに行く
		if( lv < 40 ){				// レベルが40未満の場合
			PutGameOver();			// ゲームオーバー画面の表示
		}
		else{						// レベルが40以上の場合
			PutGameClear();			// レベルに応じたゲームクリアの画面の表示
		}
	}

	// 序章を表示します。
	public static void PutJyosyou(){
		put( "魔王が" + "世界を滅ぼそうとしています。" );
		put( name + "はレベル" + lv + ",HP" + hp + "の強者です." );
	}

	// ゲームオーバー画面を表示します。
	static void PutGameOver(){
		put( name + "は魔王に敗れました..." );
		put( "GAME OVER..." );
	}

	// プレイヤーのレベルに応じたゲームクリア画面を表示します。
	static void PutGameClear(){
		String str01 = name + "は魔王を倒しました！";

		put( str01 );
		if( 200 < lv ){
			put( "魔王は言った。" );
			put( "「よくぞ参った。" + name + "よ、褒めてっ...」" );
			put( "一瞬の静粛..." );
			put( "鈍い音と共に崩れ落ちる魔王の身体。" );
			put( "その首はあるべきとこには無かった..." );
			put( name + "のチカラは魔王のそれとはもはや次元が違った。" );
		}
		else if( 120 < lv ){
			put( "レベル" + lv + "なので幸いにも犠牲を出さずに勝利できました！" );
		}
		else if( 80 < lv ){
			put( "レベル" + lv + "なので激闘の末、見事魔王を倒しました！" );
		}
		else if( 50 < lv ) {
			put( "レベル" + lv + "なので犠牲を払いつつも見事勝利しました！" );
		}
		else {
			put( "レベル" + lv + "なので、そのための代償は大きかった..." );
		}
		System.out.println( "GAME CLEAR!" );
	}

	public static void putCommand() throws java.io.IOException {
		put( "1. すぐに魔王を倒しに行く" );
		put( "2. 修行する" );
		put("3. 宿屋に泊まる");

		int c = inPutCommand();

		if(c == '1') {		// 1. すぐに魔王を倒しに行く
			put("魔王が現れた！");
		}
		else if( c == '2' ){		// 2. 修行する
			lv += 5;
			hp -= 3;
			if(hp < 0) {
				hp = 0;
			}
			put("レベルが" + lv + "になった");
			put("HPが" + hp + "になった");
			if(hp <= 0) {
				put("GAME OVER");
			}
			else {
				putCommand();
			}
		}
		else if(c == '3') {		// 3. 宿屋に泊まる
			hp = lv;
			put("HPが" + hp + "になった");
			putCommand();
		}
	}

	public static int inPutCommand() throws java.io.IOException {
		int c = System.in.read();

		if((c == 10) || (c == 13)) {
			return(inPutCommand());
		}
		return(c);
	}
	/**
	 * 引数で指定された文字列を表示します。
	 *
	 * @param str　・・・　表示対象の文字列
	 */
	static void put( String str ){
		System.out.println( str );
	}
}
