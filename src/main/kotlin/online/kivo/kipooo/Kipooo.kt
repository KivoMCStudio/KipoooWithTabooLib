package online.kivo.kipooo

import org.bukkit.ChatColor
import taboolib.common.io.newFile
import taboolib.common.platform.Plugin
import taboolib.common.platform.function.getDataFolder
import taboolib.common.platform.function.info
import taboolib.common.platform.function.releaseResourceFile
import taboolib.module.configuration.*

object Kipooo : Plugin() {

    val configFile by lazy {
        newFile(getDataFolder() , "config.yml")
    }

    val langFile by lazy {
        newFile(getDataFolder() , "lang.yml")
    }

    @Config
    lateinit var config: Configuration

    @Config
    lateinit var lang: Configuration

    override fun onLoad() {
        info("正在加载Kipooo中......")
        if (!configFile.exists()) {
            info("配置文件不存在，正在从JAR包中获取.")
            releaseResourceFile("config.yml" , true)
            info("释放成功!")
            config = Configuration.loadFromFile(configFile , Type.YAML)
            info("加载成功！")
        }
        if (!langFile.exists()) {
            info("语言文件不存在，正在从JAR包中获取.")
            releaseResourceFile("lang.yml" , true)
            info("释放成功！")
            lang = Configuration.loadFromFile(langFile , Type.YAML)
            info("加载成功！")
        }
    }

    override fun onEnable() {
        info("已经启用了Kipooo")
    }

    override fun onDisable() {
        info("Kipooo已卸载")
    }

    /**
     * 将普通文本转换为彩色文本
     * @param text 传入的文本
     * @return 返回彩色文本
     */
    @JvmStatic
    fun toColor(text : String) : String{
        return ChatColor.translateAlternateColorCodes('&' , text)
    }
}