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
        info("���ڼ���Kipooo��......")
        if (!configFile.exists()) {
            info("�����ļ������ڣ����ڴ�JAR���л�ȡ.")
            releaseResourceFile("config.yml" , true)
            info("�ͷųɹ�!")
            config = Configuration.loadFromFile(configFile , Type.YAML)
            info("���سɹ���")
        }
        if (!langFile.exists()) {
            info("�����ļ������ڣ����ڴ�JAR���л�ȡ.")
            releaseResourceFile("lang.yml" , true)
            info("�ͷųɹ���")
            lang = Configuration.loadFromFile(langFile , Type.YAML)
            info("���سɹ���")
        }
    }

    override fun onEnable() {
        info("�Ѿ�������Kipooo")
    }

    override fun onDisable() {
        info("Kipooo��ж��")
    }

    /**
     * ����ͨ�ı�ת��Ϊ��ɫ�ı�
     * @param text ������ı�
     * @return ���ز�ɫ�ı�
     */
    @JvmStatic
    fun toColor(text : String) : String{
        return ChatColor.translateAlternateColorCodes('&' , text)
    }
}