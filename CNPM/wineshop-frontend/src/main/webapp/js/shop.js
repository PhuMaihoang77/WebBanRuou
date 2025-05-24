fetch('http://localhost:8081/api/product/getAllProduct')
    .then(response => {
        if (!response.ok) {
            throw new Error('Lỗi khi gọi API');
        }
        return response.json();
    })
    .then(data => {
        const container = document.getElementById('productContainer');

        data.forEach(product => {
            const html = `
                    <div class="col-md-6 col-lg-6 col-xl-4">
                        <div class="rounded position-relative fruite-item">
                            <div class="fruite-img">
                                <img src="img/${product.image}" class="img-fluid w-100 rounded-top" alt="">
                            </div>
                            <div class="text-white bg-secondary px-3 py-1 rounded position-absolute"
                                 style="top: 10px; left: 10px;">${product.brand.name}
                            </div>
                            <div class="p-4 border border-secondary border-top-0 rounded-bottom">
                                <h4>${product.name}</h4>
                                <p>${product.description}</p>
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
            container.innerHTML += html;
        });
    })
    .catch(error => {
        console.error('Chi tiết lỗi:', error);
    });

fetch('http://localhost:8081/api/brand/getBrandsWithCount')
    .then(response => {
        if (!response.ok) {
            throw new Error('Không thể lấy dữ liệu brand');
        }
        return response.json();
    })
    .then(brands => {
        const listContainer = document.getElementById('brandList');
        listContainer.innerHTML = '';

        brands.forEach(brand => {
            const item = `
                <li>
                    <div class="d-flex justify-content-between fruite-name">
                        <a href="#"><i class="fas fa-wine-bottle me-2"></i>${brand.name}</a>
                        <span>(${brand.count})</span>
                    </div>
                </li>
            `;
            listContainer.innerHTML += item;
        });
    })
    .catch(error => {
        console.error('Lỗi khi fetch brand:', error);
    });

