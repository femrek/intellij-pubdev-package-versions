package me.femrek.pub_dev_version_fetcher.util

import com.intellij.psi.PsiElement
import com.intellij.psi.util.parentOfType
import org.jetbrains.yaml.psi.YAMLKeyValue
import org.jetbrains.yaml.psi.YAMLMapping

class AppYamlUtils {
    companion object {
        /**
         * Finds the package name from the given PsiElement.
         * It expects the element to be part of a YAMLKeyValue under dependencies or dev_dependencies.
         *
         * @param element The PsiElement to analyze.
         * @return The package name if found, null otherwise.
         */
        fun findPackageName(element: PsiElement): String? {
            // Find the nearest YAMLKeyValue parent (key-value pair)
            val keyValue = element.parentOfType<YAMLKeyValue>() ?: return null

            // Check if this key-value is under dependencies mapping
            val parentMapping = keyValue.parent as? YAMLMapping ?: return null
            val grandParentKeyValue = parentMapping.parentOfType<YAMLKeyValue>()
            if (grandParentKeyValue?.keyText != "dependencies" && grandParentKeyValue?.keyText != "dev_dependencies") {
                return null // not under dependencies or dev_dependencies
            }

            // Return the key (package name)
            return keyValue.keyText
        }
    }
}