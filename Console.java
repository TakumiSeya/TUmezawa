/**
 *
 */

/**
 * @author b1014246
 *
 */
public class Console {
  // 序章を表示します。
	public static void PutJyosyou(){
		put( "魔王が" + "世界を滅ぼそうとしています。" );
		putStatus();
	}

	public static void putStatus() {
		put("---------------");
		put("プレーヤーステータス");
		put(" 名前	" + part01.name);
		put(" Lv	" + part01.lv);
		put(" HP	" + part01.hp);
		put(" 所持金	" + part01.gold);
		put("---------------");
	}

	// ゲームオーバー画面を表示します。
	static void PutGameOver(){
		put( part01.name + "は魔王に敗れました..." );
		put( "GAME OVER..." );
	}

	// プレイヤーのレベルに応じたゲームクリア画面を表示します。
	static void PutGameClear(){
		String str01 = part01.name + "は魔王を倒しました！";

		put( str01 );
		if( 200 < part01.lv ){
			put( "魔王は言った。" );
			put( "「よくぞ参った。" + part01.name + "よ、褒めてっ...」" );
			put( "一瞬の静粛..." );
			put( "鈍い音と共に崩れ落ちる魔王の身体。" );
			put( "その首はあるべきとこには無かった..." );
			put( part01.name + "のチカラは魔王のそれとはもはや次元が違った。" );
		}
		else if( 120 < part01.lv ){
			put( "レベル" + part01.lv + "なので幸いにも犠牲を出さずに勝利できました！" );
		}
		else if( 80 < part01.lv ){
			put( "レベル" + part01.lv + "なので激闘の末、見事魔王を倒しました！" );
		}
		else if( 50 < part01.lv ) {
			put( "レベル" + part01.lv + "なので犠牲を払いつつも見事勝利しました！" );
		}
		else {
			put( "レベル" + part01.lv + "なので、そのための代償は大きかった..." );
		}
		System.out.println( "GAME CLEAR!" );
	}

	public static void putCommand() throws java.io.IOException {
		put("1. すぐに魔王を倒しに行く");
		put("2. 修行する");
		put("3. 宿屋に泊まる");

		switch(inPutCommand()) {
			case '1':
			{
				put("魔王が現れた！");
				break;
			}
			case '2':
			{
				putSygyou();
				break;
			}
			case '3':
			{
				if(part01.gold >= 10) {
					part01.hp = part01.lv;
					part01.gold -= 10;
					put("HPが回復した");
				}
				putStatus();
				putCommand();
			}
		}
	}

	/**
	* 修行する
	*
	*/
	public static void putSygyou() throws java.io.IOException {
		java.util.Random r = new java.util.Random();

		// 敵出現数
		int enamy = r.nextInt(5) + 1;
		String enamyImage1 = "   人   ";
		String enamyImage2 = " ( o_o) ";
		for(int i = 0; i < enamy; i++) {
			if(i == enamy -1) {
				put(enamyImage1);
				break;
			}
			System.out.print(enamyImage1);
		}
		for(int i = 0; i < enamy; i++) {
			System.out.print(enamyImage2);
		}
		put("\n");
		put("敵が" + enamy + "匹，現れた");

		// HPを減らす
		int damage = r.nextInt(8); // 0 <= damage < 8
		part01.hp -= damage;
		if(part01.hp < 0) {
			part01.hp = 0;
		}

		// レベリング
		part01.lv += enamy;

		put(part01.name + "は技の鍛錬を行った");
		put(part01.name + "は" + damage + "疲労した");
		putStatus();
		if(part01.hp <= 0) {
			put("その時" + part01.name + "の身体に異変が起きた");
			put("過度の鍛錬により，遂に" + part01.name + "の身体は限界を迎えたのだ");
			put(part01.name + "はその場に倒れ，それっきり動かなくなった");
			put("GAME OVER");
		}
		else {
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
