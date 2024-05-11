import React, { useState } from 'react';

const AddProductForm = ({ onSubmit }) => {
    const [brand, setBrand] = useState('');
    const [model, setModel] = useState('');
    const [generation, setGeneration] = useState('');
    const [price, setPrice] = useState('');

    const handleBrandChange = (event) => {
        setBrand(event.target.value);
    };

    const handleModelChange = (event) => {
        setModel(event.target.value);
    };

    const handleSubmit = (event) => {
        event.preventDefault();
        onSubmit({ brand, model, generation, price });
    };

    return (
        <form onSubmit={handleSubmit}>
            <label>
                Марка мотоцикла:
                <select name="brand" value={brand} onChange={handleBrandChange}>
                    <option value="">Выберите марку</option>
                    <option value="Harley-Davidson">Harley-Davidson</option>
                    <option value="Honda">Honda</option>
                    <option value="Yamaha">Yamaha</option>
                    <option value="Kawasaki">Kawasaki</option>
                    <option value="Suzuki">Suzuki</option>
                </select>
            </label>
            <br />
            <label>
                Модель:
                <input type="text" name="model" value={model} onChange={handleModelChange} />
            </label>
            <br />
            <label>
                Поколение:
                <input type="text" name="generation" value={generation} onChange={(event) => setGeneration(event.target.value)} />
            </label>
            <br />
            <label>
                Цена:
                <input type="number" step="any" name="price" value={price} onChange={(event) => setPrice(event.target.value)} />
            </label>
            <br />
            <button type="submit">Добавить продукт</button>
            <div>
                Выбранная марка: {brand}<br />
                Выбранная модель: {model}
            </div>
        </form>
    );
};

export default AddProductForm;
