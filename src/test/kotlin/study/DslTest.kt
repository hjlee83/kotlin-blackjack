package study

import dsl.introduce
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

class DslTest : FreeSpec({
    "dsl introduce 에 name " - {
        "김효건 으로 넣을시 person 의 이름은 김효건이 나온다." {
            // givne
            val value = "김효건"
            // when
            val person = introduce {
                name(value)
            }
            // then
            person.name shouldBe "김효건"
        }

        "이호진 으로 넣을시 person 의 이름은 이호진이 나온다." {
            // givne
            val value = "이호진"
            // when
            val person = introduce {
                name(value)
            }
            // then
            person.name shouldBe "이호진"
        }

        "하드스킬을 1개 넣고 소프트스킬 2개를 넣을시 소프트스킬사이즈는 2 하드스킬사이즈는 1이다." {
            // givne
            val value = "이호진"
            // when
            val person = introduce {
                name(value)
                company("우아한형제들")
                skills {
                    soft("A passion for problem solving")
                    soft("Good communication skills")
                    hard("Kotlin")
                }
                languages {
                    level("Korean", 5)
                    level("English", 3)
                }
            }

            // then
            person.name shouldBe "이호진"
            person.skills?.softSkills?.size shouldBe 2
            person.skills?.hardSkills?.size shouldBe 1
            person.languages?.size shouldBe 2

        }
    }
//    introduce {
//        name("박재성")
//        company("우아한형제들")
//        skills {
//            soft("A passion for problem solving")
//            soft("Good communication skills")
//            hard("Kotlin")
//        }
//        languages {
//            "Korean" level 5
//            "English" level 3
//        }
//    }
//    @ValueSource(strings = ["박재성", "제이슨"])
//    @ParameterizedTest
//    fun introduce(value: String) {
//        val person = introduce {
//            name(value)
//        }
//        assertThat(person.name).isEqualTo(value)
//    }
//
//    @Test
//    fun company() {
//        val person = introduce {
//            name("박재성")
//            company("우아한형제들")
//        }
//        assertThat(person.name).isEqualTo("박재성")
//        assertThat(person.company).isEqualTo("우아한형제들")
//    }

})
