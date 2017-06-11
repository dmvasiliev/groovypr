package sixth

import groovy.io.FileType

/**
 * Created by vasiliev on 6/9/2017.
 */
class DeleteAllFiles {
    def deleteAllFiles = { String path ->
        new File(path).eachFileRecurse(FileType.FILES) {
            new File(it.toString()).delete()
        }
    }
}
