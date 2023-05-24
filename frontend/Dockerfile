# Stage 1: Build the app
FROM node as build-stage

# Set the working directory in the container
WORKDIR /app

# Copy package.json and package-lock.json to the working directory
COPY package*.json ./

# Install the app dependencies
RUN npm update --save && npm install

# Copy the entire app directory to the working directory
COPY . .

# Build the Angular app for production
RUN npm run build -- --configuration=production

# Stage 2: Serve the app using Nginx
FROM nginx:alpine as production-stage
COPY nginx.conf /etc/nginx/conf.d/default.conf

# Copy the built app from the previous stage
COPY --from=build-stage /app/dist/frontend /usr/share/nginx/html

# Expose the port the app will run on (default is 80 for Nginx)
EXPOSE 3000

# Start Nginx
CMD ["nginx", "-g", "daemon off;"]