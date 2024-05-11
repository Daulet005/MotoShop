const ProductTable = ({ products }) => (
    <table>
        <thead>
        <tr>
            <th>Название продукта</th>
            <th>Цена продукта</th>
        </tr>
        </thead>
        <tbody>
        {products.map((product, index) => (
            <ProductRow key={index} product={product} />
        ))}
        </tbody>
    </table>
);

// Компонент для формы добавления продукта
const AddProductForm = ({ onSubmit }) => (
    <form onSubmit={onSubmit}>
        <label>
            Название:
            <input type="text" name="name" />
        </label>
        <br />
        <label>
            Цена:
            <input type="number" step="any" name="price" />
        </label>
        <label>
            Id:
            <input type="hidden" name="id" value="" />
        </label>
        <br />
        <br />
        <button type="submit">Добавить продукт</button>
    </form>
);

// Основной компонент страницы с продуктами
const ProductsPage = ({ products, onSubmit }) => (
    <div>
        <h1>Продукты</h1>
        <h2>Просмотр продуктов</h2>
        <ProductTable products={products} />
        <h2>Добавить продукт</h2>
        <AddProductForm onSubmit={onSubmit} />
    </div>
);

export default ProductsPage;