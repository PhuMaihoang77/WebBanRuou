INSERT INTO brands (name, is_deleted)
VALUES (N'Chardonnay', 0),
       (N'Merlot', 0),
       (N'Cabernet', 0),
       (N'PinotNoir', 0),
       (N'Sauvignon', 0);

INSERT INTO products (brand_id, name, price, description, image, capacity, alcohol, status, year, is_deleted) VALUES
-- Chardonnay
(1, N'Chardonnay Gold Label', 250, N'Chai Chardonnay hảo hạng niên vụ 2021 với hương vị nhẹ nhàng và thanh thoát.', 'Chardonnay_1.jpg', 750, 13.5, N'Còn hàng', 2021, 0),
(1, N'Chardonnay Classic', 255, N'Rượu trắng truyền thống với hương trái cây đặc trưng và hậu vị sâu lắng.', 'Chardonnay_2.jpg', 750, 13.5, N'Còn hàng', 2021, 0),
(1, N'Chardonnay Premium 2021', 260, N'Phiên bản giới hạn của Chardonnay với nốt hương táo xanh và cam quýt.', 'Chardonnay_3.jpg', 750, 13.5, N'Còn hàng', 2021, 0),
(1, N'Chardonnay Vintage', 265, N'Hương vị tinh tế với độ axit cân bằng, phù hợp với các món hải sản.', 'Chardonnay_4.jpg', 750, 13.5, N'Còn hàng', 2021, 0),
(1, N'Chardonnay Reserve', 270, N'Chardonnay đậm đà và sâu lắng, ủ trong thùng gỗ sồi cao cấp.', 'Chardonnay_5.jpg', 750, 13.5, N'Còn hàng', 2021, 0),

-- Merlot
(2, N'Merlot Ruby Red', 280, N'Vang đỏ Merlot mềm mại, vị trái mọng và hậu vị êm dịu.', 'Merlot_1.jpg', 750, 14.0, N'Còn hàng', 2020, 0),
(2, N'Merlot Heritage', 285, N'Hương vị cổ điển đậm đà với nốt dâu đen và gia vị nhẹ.', 'Merlot_2.jpg', 750, 14.0, N'Còn hàng', 2020, 0),
(2, N'Merlot Signature', 290, N'Merlot thượng hạng cho những bữa tiệc sang trọng.', 'Merlot_3.jpg', 750, 14.0, N'Còn hàng', 2020, 0),
(2, N'Merlot Barrel Aged', 295, N'Ủ thùng gỗ sồi 12 tháng, tạo nên hương thơm phức hợp và đậm đà.', 'Merlot_4.jpg', 750, 14.0, N'Còn hàng', 2020, 0),
(2, N'Merlot Private Collection', 300, N'Tuyển chọn những trái nho ngon nhất để tạo ra hương vị tuyệt vời.', 'Merlot_5.jpg', 750, 14.0, N'Còn hàng', 2020, 0),

-- Cabernet
(3, N'Cabernet Sauvignon Bold', 310, N'Cabernet mạnh mẽ với tannin chắc và nốt socola đen.', 'Cabernet_1.jpg', 750, 13.0, N'Còn hàng', 2019, 0),
(3, N'Cabernet Classic Reserve', 315, N'Vị đậm, cấu trúc chắc, lý tưởng cho thịt đỏ.', 'Cabernet_2.jpg', 750, 13.0, N'Còn hàng', 2019, 0),
(3, N'Cabernet Oak Cask', 320, N'Hương gỗ sồi nhẹ và trái cây đen hòa quyện.', 'Cabernet_3.jpg', 750, 13.0, N'Còn hàng', 2019, 0),
(3, N'Cabernet Special Edition', 325, N'Phiên bản giới hạn với sự cân bằng tuyệt vời.', 'Cabernet_4.jpg', 750, 13.0, N'Còn hàng', 2019, 0),
(3, N'Cabernet Noir Elegance', 330, N'Tuyệt phẩm vang đỏ với vị mận chín và hạt tiêu đen.', 'Cabernet_5.jpg', 750, 13.0, N'Còn hàng', 2019, 0),

-- PinotNoir
(4, N'Pinot Noir Velvet', 340, N'Vang đỏ nhẹ nhàng, mượt mà như nhung.', 'PinotNoir_1.jpg', 750, 12.5, N'Còn hàng', 2022, 0),
(4, N'Pinot Noir Rose Garden', 345, N'Mùi hương hoa hồng và dâu tây tươi mát.', 'PinotNoir_2.jpg', 750, 12.5, N'Còn hàng', 2022, 0),
(4, N'Pinot Noir Sublime', 350, N'Chất rượu mịn, hậu vị kéo dài với nốt đất nhẹ.', 'PinotNoir_3.jpg', 750, 12.5, N'Còn hàng', 2022, 0),
(4, N'Pinot Noir Grand Cru', 355, N'Được chọn lọc từ vườn nho cổ thụ, mang đến sự tinh tế.', 'PinotNoir_4.png', 750, 12.5, N'Còn hàng', 2022, 0),
(4, N'Pinot Noir Élite', 360, N'Sự kết hợp hoàn hảo giữa nhẹ nhàng và sâu sắc.', 'PinotNoir_5.jpg', 750, 12.5, N'Còn hàng', 2022, 0),

-- Sauvignon
(5, N'Sauvignon Blanc Fresh', 370, N'Rượu trắng mát lạnh, vị cam quýt và chanh leo.', 'Sauvignon_1.jpg', 750, 13.2, N'Còn hàng', 2023, 0),
(5, N'Sauvignon Blanc Zesty', 375, N'Hậu vị giòn và sảng khoái, lý tưởng cho mùa hè.', 'Sauvignon_2.jpg', 750, 13.2, N'Còn hàng', 2023, 0),
(5, N'Sauvignon Blanc Citrus Delight', 380, N'Trong trẻo với hương vỏ cam và bưởi chín.', 'Sauvignon_3.jpg', 750, 13.2, N'Còn hàng', 2023, 0),
(5, N'Sauvignon Blanc Dry Finish', 385, N'Khô, sạch và sắc nét với thảo mộc nhẹ.', 'Sauvignon_4.jpg', 750, 13.2, N'Còn hàng', 2023, 0),
(5, N'Sauvignon Blanc Prestige', 390, N'Vang trắng cao cấp cho những dịp đặc biệt.', 'Sauvignon_5.png', 750, 13.2, N'Còn hàng', 2023, 0);
