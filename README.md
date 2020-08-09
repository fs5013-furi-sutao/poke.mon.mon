# 「モンスター捕獲ゲーム」サンプルコード  
poke.mon.mon  

このリポジトリは「モンスター捕獲ゲーム」のサンプルコードです。

## 遊び方  
10 匹のモンスターが次々と現れる。捕獲玉を使って捕獲しよう。  

モンスターを捕獲できれば、モンスターごとに設定されたポイントを獲得できる。3 種類ある捕獲玉をうまく使って、高得点を目指そう。  

## ゲームの仕様  
モンスター捕獲ゲームの仕様は以下の通り  

### モンスターに出会う回数  
モンスターは10匹登場する（「10匹」は設定で可変にする）  

### 次に出現するモンスター  
各モンスターが持つ出現率を元に、毎回ランダムに決める  

### プレイヤーの選択肢  
プレイヤーは以下のいずれかの行動を行うことができる  

1. ｘｘ獲得玉を使う(残りｘ個。捕獲成功率：ｘｘ％)
2. ｘｘ獲得玉を使う(残りｘ個。捕獲成功率：ｘｘ％)
3. ｘｘ獲得玉を使う(残りｘ個。捕獲成功率：ｘｘ％)
4. モンスターを見逃す

### 使える捕獲玉  
所持数がゼロの捕獲玉を使うことはできない  

### 捕獲成功判定  
モンスター毎の捕獲率と、捕獲玉の補正率で決める  

### 捕獲失敗時  
捕獲に失敗した場合は、捕獲に失敗した旨のメッセージを表示し、再度アクションを選択させる  

### ゲーム終了条件  
捕獲玉が１つもなくなった場合、または、１０匹目のモンスターを捕獲もしくは見逃しをした場合はゲームは終了  

### ゲーム終了時  
捕獲したモンスターの一覧と合計獲得ポイントを表示する  
