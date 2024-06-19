# Stage 1: Build the Angular application
FROM node:16-alpine AS build

# Set the working directory inside the container
WORKDIR /usr/src/app

# Copy package.json and package-lock.json to the container
COPY package*.json ./

# Install dependencies, including additional ones if needed
RUN npm install bootstrap && npm install

# Copy the rest of the app's source code to the container
COPY . .

# Build the Angular app
RUN npm run build -- --configuration production

# Stage 2: Serve the Angular application using NGINX
FROM nginx:alpine

# Copy the built app from the previous stage to the Nginx directory
COPY --from=build /usr/src/app/dist/webapp /usr/share/nginx/html
COPY --from=build /usr/src/app/nginx.conf /etc/nginx/nginx.conf

# Expose port 80 (the default Nginx port)
EXPOSE 80

# Start Nginx when the container runs
CMD ["nginx", "-g", "daemon off;"]
