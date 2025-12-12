package dsl

fun introduce(block: PersonBuilder.() -> Unit): Person {
    return PersonBuilder().apply(block).build()
}

class PersonBuilder {
    private lateinit var name: String
    private var company: String? = null
    private var skills: Skills? = null
    private var languages: List<Language>? = null

    fun name(value: String) {
        name = value
    }

    fun company(value: String) {
        company = value
    }

    fun skills(block: SkillBuilder.() -> Unit) {
        skills = SkillBuilder().apply(block).build()
    }

    fun languages(block: LanguageBuilder.() -> Unit) {
        languages = LanguageBuilder().apply(block).build()
    }

    fun build(): Person {
        return Person(name, company, skills, languages)
    }
}

data class Person(val name: String, val company: String?, val skills: Skills?, val languages: List<Language>?)

class SkillBuilder {
    private var softSkills: List<String> = listOf()
    private var hardSkills: List<String> = listOf()

    fun soft(value: String) {
        softSkills += value
    }

    fun hard(value: String) {
        hardSkills += value
    }

    fun build(): Skills {
        return Skills(softSkills, hardSkills)
    }
}

class Skills(val softSkills: List<String>, val hardSkills: List<String>)
data class Language(val name: String, val level: Int)

class LanguageBuilder {
    private var languages: List<Language> = listOf()

    fun level(name : String, level : Int) : Language {
        return Language(name, level)
    }

    fun add(language : Language) {
        languages += language
    }

    fun build(): List<Language> {
        return languages
    }
}
