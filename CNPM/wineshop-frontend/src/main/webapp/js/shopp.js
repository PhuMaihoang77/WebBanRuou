let selectedBrand = null;
let selectedAlcohol = null;
let selectedMaxPrice = null;
let minPrice = null;
let maxPrice = null;

$(document).ready(function () {
    // Lấy min & max price từ backend để khởi tạo slider
    $.ajax({
        url: 'http://localhost:8081/api/product/price-range',
        method: 'GET',
        success: function (data) {
            minPrice = data.minPrice;
            maxPrice = data.maxPrice;
            selectedMaxPrice = maxPrice;

            $('#rangeInput').attr('min', minPrice);
            $('#rangeInput').attr('max', maxPrice);
            $('#rangeInput').val(maxPrice);
            $('#amount').val('$'+ maxPrice);

            // Lấy toàn bộ sản phẩm lần đầu với filter maxPrice = max từ DB
            applyFilters();

            // Lấy toàn bộ data để render filter brand + alcohol (ở lần đầu load)
            fetchAllProductsForFilters();
        },
        error: function () {
            console.error('Không lấy được range giá từ backend');
            // fallback nếu backend lỗi thì vẫn lấy tất cả
            fetchAllProductsForFilters();
            applyFilters();
        }
    });

    // Sự kiện lọc theo giá
    $('#rangeInput').on('input', function () {
        selectedMaxPrice = $(this).val();
        $('#amount').val('$ '+selectedMaxPrice);
        // console.log("Lọc theo giá <= ", '$'+selectedMaxPrice);
        applyFilters();
    });

    // Sự kiện lọc theo brand
    $('#brands').on('click', 'a', function (e) {
        e.preventDefault();
        selectedBrand = $(this).text().trim();
        applyFilters();
    });

    // Sự kiện lọc theo nồng độ
    $('#concentrations').on('change', 'input[type=checkbox]', function () {
        selectedAlcohol = $(this).is(':checked') ? $(this).val() : null;
        applyFilters();
    });
});

// Lấy toàn bộ sản phẩm để chỉ render brand + alcohol filter (chỉ gọi 1 lần lúc đầu)
function fetchAllProductsForFilters() {
    $.ajax({
        url: 'http://localhost:8081/api/product/getAllProduct',
        method: 'GET',
        success: function (data) {
            renderBrands(data);
            renderConcentrations(data);
        },
        error: function (xhr) {
            console.error('Lỗi khi lấy dữ liệu sản phẩm để render filter:', xhr);
        }
    });
}

// Gọi API lọc sản phẩm theo filter đang chọn
function applyFilters() {
    let url = 'http://localhost:8081/api/product/filter?';

    if (selectedBrand) url += `brand=${encodeURIComponent(selectedBrand)}&`;
    if (selectedAlcohol) url += `alcohol=${selectedAlcohol}&`;
    if (selectedMaxPrice) url += `maxPrice=${selectedMaxPrice}`;

    $.ajax({
        url: url,
        method: 'GET',
        success: function (data) {
            renderProducts(data);
        },
        error: function (xhr) {
            console.error('Lỗi khi lọc sản phẩm:', xhr);
        }
    });
}

// Hiển thị sản phẩm
function renderProducts(products) {
    const container = $('#productContainer');
    container.empty();

    if (products.length === 0) {
        container.html('<p>Không tìm thấy sản phẩm nào phù hợp.</p>');
        return;
    }

    $.each(products, function (index, product) {
        const html = `
            <div class="col-md-6 col-lg-6 col-xl-4">
                <div class="rounded position-relative fruite-item">
                    <div class="fruite-img">
                        <img src="img/${product.image}" class="img-fluid w-100 rounded-top" alt="${product.name}">
                    </div>
                    <div class="text-white bg-secondary px-3 py-1 rounded position-absolute" style="top: 10px; left: 10px;">
                        ${product.brand?.name || 'none'}
                    </div>
                    <div class="p-4 border border-secondary border-top-0 rounded-bottom">
                        <h4>${product.name}</h4>
                        <p>${product.description || ''}</p>
                        <div class="d-flex justify-content-between flex-lg-wrap">
                            <p class="text-dark fs-5 fw-bold mb-0">$${product.price}</p>
                            <a href="#" class="btn border border-secondary rounded-pill px-3 text-primary">
                                <i class="fa fa-shopping-bag me-2 text-primary"></i> Add to cart
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        `;
        container.append(html);
    });
}

// Hiển thị danh sách brand (dùng để người dùng chọn lọc)
function renderBrands(products) {
    const container = $('#brands');
    container.empty();

    const brandCount = new Map();
    $.each(products, function (i, product) {
        if (product.brand && product.brand.name) {
            const name = product.brand.name;
            brandCount.set(name, (brandCount.get(name) || 0) + 1);
        }
    });

    brandCount.forEach((count, name) => {
        const html = `
            <li>
                <div class="d-flex justify-content-between fruite-name">
                    <a href="#"><i class="fas fa-wine-bottle me-2 text-primary"></i>${name}</a>
                    <span>(${count})</span>
                </div>
            </li>
        `;
        container.append(html);
    });
}

// Hiển thị danh sách nồng độ (alcohol)
function renderConcentrations(products) {
    const container = $('#concentrations');
    container.empty();

    const set = new Set();
    $.each(products, function (i, product) {
        if (product.alcohol != null) set.add(product.alcohol);
    });

    [...set].sort((a, b) => a - b).forEach(value => {
        const html = `
            <div class="mb-2">
                <input type="checkbox" class="me-2" value="${value}">
                <label>${value} %</label>
            </div>
        `;
        container.append(html);
    });
}
