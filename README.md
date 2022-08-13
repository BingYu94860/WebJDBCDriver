## Getting Started

Welcome to the VS Code Java world. Here is a guideline to help you get started to write Java code in Visual Studio Code.

## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

Meanwhile, the compiled output files will be generated in the `bin` folder by default.

> If you want to customize the folder structure, open `.vscode/settings.json` and update the related settings there.

## Dependency Management

The `JAVA PROJECTS` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).


## 環境設置
- 作業系統: Windows 11
- 編輯器: VS Code
- JAVA SDK 8u341 or 17
- MySQL JDBC Driver 8.0.30

## 在命令提示字元，執行 xxx.java 時，解決中文亂碼方法
```batch
chcp 65001
java -Dfile.encoding=utf-8 xxx.java
```

## 永久設置 `chcp 65001` 方法
- 按下 **Win+R** 後，輸入 **regedit** ，開啟 登錄編輯程式。
- 按順序找到 `HKEY_LOCAL_MACHINE\SOFTWARE\Microsoft\Command Processor`
- 點選右鍵 **新增** 並選擇 **字串值** 命名為 `Autorun`
- 右鍵點擊 **修改** 並將 **數值資料** 填寫為 `chcp 65001`
- 參考: [Windows CMD 永久設定UTF-8編碼](https://iter01.com/591854.html)

## 永久設置 `-Dfile.encoding=utf-8` 方法
- 按下 **Win+R** 後，輸入 **SystemPropertiesAdvanced** ，點選開啟 環境變數。
- 在 **user的使用者變數** 裡，點選 **新增** ，並設置 **變數名稱** 為 `JAVA_TOOL_OPTIONS` 以及 **變數值** 為 `-Dfile.encoding=UTF-8`

## 其他參考
[Getting Started with Java in VS Code](https://code.visualstudio.com/docs/java/java-tutorial)
[Java project management in VS Code](https://code.visualstudio.com/docs/java/java-project)
[How to Add JAR file to Classpath in Java?](https://www.geeksforgeeks.org/how-to-add-jar-file-to-classpath-in-java/)
