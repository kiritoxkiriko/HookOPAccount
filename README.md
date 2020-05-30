# HookOPAccount
## 简介
一个Xposed模块 HookOPAccount  
让一加8/8pro 氧OS使用一加钱包 (仅在本人的1+8pro上测试过，理论上1+8全系通用，1+7T有人尝试也成功了)
请与此[magisk模块](https://github.com/kiritoxkiriko/HookOPAccount/releases/download/1.2/OOSCNAccount.zip)配合使用

## 步骤
1. 退出已登录的一加账户
2. 刷入 magisk模块 [OOSCNAccount.zip](https://github.com/kiritoxkiriko/HookOPAccount/releases/download/latest/OOSCNAccount.zip) 和本项目的xposed模块 [HookOPAccount.apk](https://github.com/kiritoxkiriko/HookOPAccount/releases/download/latest/HookOPAccount.apk)
3. 重启后安装 [Wallet.apk](https://github.com/kiritoxkiriko/HookOPAccount/releases/download/latest/Wallet.apk)，搞定
4. 此时双击电源键调出公交卡开关无法打开，解决方法:
   1. 确保自己的电脑安有adb调试工具 (安装方法请自行搜索)
   2. 命令行输入```adb shell pm grant com.finshell.wallet android.permission.WRITE_SECURE_SETTINGS```
   3. 此时开关可以打开了，完美解决 

## 已知的bug： 
1. 卸载magisk模块后，系统自带的Account应用会消失，目前暂时没有太好的解决办法   
   如果需要原版Account请在**卸载模块前**从play store里安装Oneplus Account，**注意是卸载模块前！！！** 也可以安装relese里面的 [Account.apk](https://github.com/kiritoxkiriko/HookOPAccount/releases/download/latest/Account.apk)
2. ~~无法设置双击直接调出公交卡，怀疑缺少底层文件，暂未发现解决办法~~ 已解决

## 注意事项
1. 请不要更新OnePlus Account应用，更新后xposed模块会失效，如已更新请先在系统设置里卸载更新
2. 重启设备不会使双击电源键调出公交卡失效，但重装Wallet应用会失效。重复步骤4，再次运行adb命令即可恢复
3. 理论上Wallet应用的版本不影响模块效果，但一切以测试为准 (Relese中的3.4.1版本亲测可用)
3. 欢迎转载到各大论坛，但请注明出处



本项目的 [Xposed Repo](https://repo.xposed.info/module/com.kiritoxkiriko.opaccounthook)




