package furamaResort.services.facility;

import furamaResort.models.*;
import furamaResort.utils.ReadAndWriteMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class FacilityServiceImpl {
    public static Map<Facility, Integer> facilityMap = new LinkedHashMap<>();
    //khoi tạo giá trị cho list từ file:
    static {
        facilityMap.putAll(VillaIplm.villaMap);
        facilityMap.putAll(HouseIplm.houseMap);
        facilityMap.putAll(RoomIplm.roomMap);
    }
}
/*note:
1. NG - Chức năng Edit(): Tại sao
+ Nếu đọc file --> gán kết quả cho list mới khởi tạo --> Vẫn edit thành công, nhưng nếu đang trong luồng chạy --> sau khi edit--> display --> không update thông tin mới.
 --> Nhưng nếu thoát luồng, chạy lại -->ok
+ Nếu gọi sử dụng trực tiếp "roomMap" --> OK
2. NG - display(): mỗi loại dịch vụ chỉ display ra đc những thuộc tính riêng --> writeFile() đang có vấn đề?? hay readFile()??/
--> do chưa toString()
2.  làm sao để hiển thị số tiền theo định dạng $, nhưng vẫn là kiểu số thực?
   vì nếu để là double --> nếu số tiền >=100tr --> vượt range
   2. hàm edit() phải viết 3 method riêng??
   3. file data: có thể lưu hết 3 map 3 loại service vào cùng 1 file "facility" để tiện thao tác k?

   4. NOTE Kinh nghiệm: Ex InvalidClassException....: xảy ra khi: file data rỗng --> lỗi
    khắc phục: cho khối static khởi tạo giá trị cho vilaMap/houseMap..--> writeFile --> display lại -->ok
*/
