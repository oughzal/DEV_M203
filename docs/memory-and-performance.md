# Guide: Tuning mémoire pour Gradle et Android Studio

Ce guide explique les changements appliqués au projet pour corriger des problèmes de mémoire et donne une checklist pour valider les effets.

## Ce que j'ai changé
- Ajouté/ajusté des paramètres dans `gradle.properties` (racine du projet) :
  - `org.gradle.jvmargs=-Xmx6g -XX:MaxMetaspaceSize=1g -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=C:/Users/Omar/gradle-heapdumps -Dfile.encoding=UTF-8 -XX:+UseG1GC`
  - `org.gradle.daemon=true`
  - `org.gradle.parallel=true`
  - `org.gradle.configureondemand=true`
  - `org.gradle.caching=true`
  - `kotlin.daemon.jvm.options=-Xmx4g -Dfile.encoding=UTF-8`
  - `kotlin.incremental=true`

Ces valeurs ont été choisies pour une machine avec ~32GB RAM et 16 coeurs logiques. Si votre machine a moins de RAM, réduisez `-Xmx` en conséquence (voir section "Valeurs sûres par RAM").

## Valeurs sûres par RAM (rappel)
- <= 4GB : `org.gradle.jvmargs=-Xmx768m ...` ; `kotlin.daemon.jvm.options=-Xmx512m`
- 4-8GB : `org.gradle.jvmargs=-Xmx1536m ...` ; `kotlin.daemon.jvm.options=-Xmx1g`
- >= 8GB : `org.gradle.jvmargs=-Xmx3g ...` ; `kotlin.daemon.jvm.options=-Xmx2g`

## Augmenter la mémoire d'Android Studio (Windows)
1. Ouvrir Android Studio.
2. Help → Edit Custom VM Options.
3. Modifier/ajouter les lignes (exemple pour 32GB) :
   - `-Xms512m`
   - `-Xmx4096m`
   - `-XX:MaxMetaspaceSize=1024m`
   - `-XX:+UseG1GC`
4. Enregistrez et redémarrez Android Studio.

Si le menu n'est pas disponible, créez manuellement `studio64.exe.vmoptions` dans le dossier de configuration utilisateur (ex: `%USERPROFILE%\.AndroidStudio<version>\config\`).

## Checklist de validation (exécuter dans PowerShell à la racine du projet)
- Vérifier la version et la JVM :
  - `.\gradlew --version`
- Voir l'état des daemons :
  - `.\gradlew --status`
- Forcer l'arrêt des daemons (pour recharger les options) :
  - `.\gradlew --stop`
- Lancer un build instrumenté et observer la sortie :
  - `.\gradlew clean assembleDebug --info`
- Si une erreur OOM se produit et que vous avez activé heapdumps, vérifiez `C:/Users/Omar/gradle-heapdumps`.

## Risques et mitigations
- Allouer plus de mémoire que disponible provoque du swap et ralentit le système : augmentez par paliers et surveillez Task Manager.
- `org.gradle.parallel=true` et `configureondemand` peuvent casser certains plugins : si vous observez erreurs inattendues, désactivez-les temporairement.
- Les changements globaux dans `%USERPROFILE%\.gradle\gradle.properties` affectent tous les projets — préférez la configuration de projet si vous n'êtes pas sûr.

## Procédure de rollback rapide
- Supprimez ou commentez les lignes ajoutées dans `gradle.properties`.
- Exécutez `.\gradlew --stop` puis `.\gradlew clean assembleDebug`.

---

Si vous voulez que j'applique ces mêmes réglages globalement (dans `%USERPROFILE%\.gradle\gradle.properties`) ou que j'ajuste davantage pour un profil CI, dites-moi et je m'en occuperai. Je peux aussi appliquer les options recommandées pour Android Studio en écrivant `studio64.exe.vmoptions` si vous voulez que je le fasse (nécessite confirmation de chemin et que l'IDE soit fermé).
