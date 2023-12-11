# SpringBootPracticeAPI

Este proyecto consiste en una API robusta y escalable con una estructura de microservicios que te permitirá desplegar y gestionar tus recursos de manera eficiente.

## Características Principales

- **Microservicios Poderosos**: Dos APIs interconectadas que trabajan juntas para ofrecer un rendimiento excepcional y una arquitectura flexible.
- **Java con Spring Boot**: Desarrollado con el poderoso framework Spring Boot en Java, garantizando un código limpio y modular.
- **Tecnologías Avanzadas**: Utiliza tecnologías de vanguardia como RestTemplate, JpaRepository, y más, para proporcionar una experiencia de desarrollo sin igual.
- **Base de Datos PostgreSQL**: Almacenamiento confiable y eficiente con PostgreSQL como base de datos principal.
- **Docker Ready**: Crea y despliega fácilmente la aplicación utilizando Docker. Incluye Dockerfile y Docker Compose para una implementación sin complicaciones.

## Instrucciones de Uso

1. **Clona el Repositorio**:
    ```bash
    git clone https://github.com/MaximoGalindo/SpringBootPracticeAPI.git
    cd SpringBootPracticeAPI
    ```

2. **Configura la Base de Datos**:
    - Asegúrate de tener un servidor PostgreSQL en ejecución.
    - Configura las credenciales en `application.properties` para la conexión.

3. **Compila y Ejecuta**:
    ```bash
    ./mvnw clean install
    ./mvnw spring-boot:run
    ```

4. **Despliega con Docker**:
    ```bash
    docker-compose up -d
    ```

5. **¡Explora y Disfruta!**:
    - Accede a la documentación de la API en [localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html).
    - Experimenta con las rutas y funcionalidades proporcionadas.

## Contribuciones

¡Las contribuciones son bienvenidas! Si tienes ideas para mejorar este proyecto, ¡adelante! Siéntete libre de crear problemas, enviar solicitudes de extracción y compartir tus pensamientos.

## Licencia

Este proyecto está bajo la Licencia [MIT](LICENSE) - Detalles [aquí](LICENSE).

---

**¡Haz tu backend asombroso con Awesome Backend API! 🚀**
