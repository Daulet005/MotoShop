// server.js

const express = require('express');
const mongoose = require('mongoose');
const bodyParser = require('body-parser');
const User = require('./models/User'); // Предположим, что у вас есть модель User для работы с пользователями

const app = express();
const PORT = process.env.PORT || 3000;

app.use(bodyParser.json());

// Подключение к базе данных MongoDB
mongoose.connect('mongodb://localhost:27017/myapp', { useNewUrlParser: true, useUnifiedTopology: true })
    .then(() => console.log('MongoDB connected'))
    .catch(err => console.log(err));

// Обработка запроса на проверку логина и пароля
app.post('/check-login', async (req, res) => {
    const { login, password } = req.body;
    try {
        const user = await User.findOne({ login, password });
        if (user) {
            res.status(200).send({ redirect: '/index.html' });
        } else {
            res.status(401).send({ message: 'Неверное имя пользователя или пароль' });
        }
    } catch (err) {
        console.error(err);
        res.status(500).send({ message: 'Ошибка сервера' });
    }
});

app.listen(PORT, () => console.log(`Server running on port ${PORT}`));
