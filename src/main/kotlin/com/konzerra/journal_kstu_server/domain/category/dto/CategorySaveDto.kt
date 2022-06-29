
package  com.konzerra.journal_kstu_server.domain.category.dto
    

import com.konzerra.journal_kstu_server.domain.category.category_data.CategoryData
import com.konzerra.journal_kstu_server._generic.data.SaveDtoI

class CategorySaveDto(
    var dataList: List<CategoryData>
): SaveDtoI
    