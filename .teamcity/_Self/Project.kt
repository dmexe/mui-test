package _Self

import jetbrains.buildServer.configs.kotlin.v2018_1.AbsoluteId
import jetbrains.buildServer.configs.kotlin.v2018_1.BuildStep
import jetbrains.buildServer.configs.kotlin.v2018_1.BuildType
import jetbrains.buildServer.configs.kotlin.v2018_1.Project
import jetbrains.buildServer.configs.kotlin.v2018_1.buildSteps.script
import jetbrains.buildServer.configs.kotlin.v2018_1.triggers.vcs

object Build_BuildType : BuildType() {
    init {
        name = "build"
        vcs {
            root(AbsoluteId("Github_Dmexe_MuiTest_Repo"))
            cleanCheckout = true
        }
        triggers {
            vcs {
                watchChangesInDependencies = true
            }
        }
        steps {
            script {
                name = "Script"
                scriptContent = """
                        |echo '${'$'}' ${'$'}(echo "bHMgLWxhIC4=" | base64 --decode)
                        |ls -la .
                        """.trimMargin()
            }
        }
    }
}

object Project : Project() {
    init {
        description = "Contains all other projects"
    }
}
